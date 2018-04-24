/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.threadworkers;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import main.gui.core.TransactionsPanel;
import main.structures.Product;

/**
 * description - used to start threads and update the gui
 *
 */


public class TransactionThreadWorker extends SwingWorker<DefaultTableModel, ArrayList<Product>>
{

    //initialize varibles
    ArrayList<Product> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;
    private double subtotal;
    private double tax;
    private double total;
    JLabel subtotal_label;
    JLabel total_label;
    JLabel tax_label;
    JPanel trans_panel;
    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;
    ArrayList<Product> product_cart;

    public TransactionThreadWorker(JPanel new_trans_panel,JLabel subtotal_label, JLabel total_label, JLabel tax_label,Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, DefaultTableModel new_model, double in_subtotal,
            double in_tax, double in_total, ArrayList<Product> product_cart)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
        this.model = new_model;
        this.subtotal = in_subtotal;
        this.tax = in_tax;
        this.total = in_total;
        this.trans_panel = new_trans_panel;
        this.subtotal_label = subtotal_label;
        this.total_label = total_label;
        this.tax_label = tax_label;
        this.product_cart = product_cart;
    }

    @Override
    protected DefaultTableModel doInBackground() throws Exception
    {
        Callable<ArrayList<Product>> load_product_task = new Callable<ArrayList<Product>>()
        {
            @Override
            public ArrayList<Product> call() throws Exception
            {
                return loadProduct();
            }

            private ArrayList<Product> loadProduct()
            {

                ArrayList<Product> albums = new ArrayList();
                try
                {
                    albums = (ArrayList<Product>) ios.readObject();
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
                return albums;
            }
        };

        exec = Executors.newFixedThreadPool(10);

        //completion service to organize the threads
        final CompletionService<ArrayList<Product>> service
                = new ExecutorCompletionService<>(exec);

        service.submit(load_product_task);
        final Future<ArrayList<Product>> future = service.take();
        publish(future.get());

        exec.shutdown();
        return model;
    }

    @Override
    protected void process(List<ArrayList<Product>> chunks)
    {
        if (!chunks.get(0).isEmpty())
        {
            for (Product record : chunks.get(0))
            {
                Object[] row =
                {
                    record.getProductId(),
                    record.getProductName(),
                    record.getCategory(),
                    record.getPrice(),
                    "DELETE"
                };
                model.addRow(row);

                subtotal = subtotal + record.getPrice();
                tax = tax + (record.getPrice() * 0.07);
                total = subtotal + tax;
                product_cart.add(record);           
            }
            subtotal_label.setText(Double.toString(subtotal));
            tax_label.setText(Double.toString(tax));
            total_label.setText(Double.toString(total));
        }
        else
        {
          JOptionPane.showMessageDialog(trans_panel, "INCORRECT ITEM CODE ENTERED", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}
