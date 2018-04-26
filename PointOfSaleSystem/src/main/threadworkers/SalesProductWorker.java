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
import javax.swing.JComboBox;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import main.structures.TransactionProduct;

/**
 * description - used to start threads and update the gui
 *
 */
public class SalesProductWorker extends SwingWorker<DefaultTableModel, ArrayList<TransactionProduct>>
{
    //initialize varibles
    ArrayList<TransactionProduct> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;
    JComboBox product_box;
    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;

    public SalesProductWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, DefaultTableModel new_model, JComboBox product_box)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
        this.model = new_model;
        this.product_box = product_box;
    }

    @Override
    protected DefaultTableModel doInBackground() throws Exception
    {
        Callable<ArrayList<TransactionProduct>> load_product_task 
                = new Callable<ArrayList<TransactionProduct>>()
        {
            @Override
            public ArrayList<TransactionProduct> call() throws Exception
            {
                System.out.println("Sales Product worker CALL FUNCTION");
                return loadTransaction();
            }

            private ArrayList<TransactionProduct> loadTransaction()
            {

                ArrayList<TransactionProduct> albums = new ArrayList();
                try
                {
                    albums = (ArrayList<TransactionProduct>) ios.readObject();

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
        final CompletionService<ArrayList<TransactionProduct>> service
                = new ExecutorCompletionService<>(exec);

        service.submit(load_product_task);
        final Future<ArrayList<TransactionProduct>> future = service.take();
        publish(future.get());

        exec.shutdown();
        return model;
    }

    @Override
    protected void process(List<ArrayList<TransactionProduct>> chunks)
    {
        model.setNumRows(0);
        ArrayList<String>product_list = new ArrayList();
        product_box.removeAllItems();
        product_box.addItem("ALL");
       
        if (!chunks.get(0).isEmpty())
        {
            for (TransactionProduct record : chunks.get(0))
            {
                Object[] row =
                {
                    record.getTransactionId(),
                    record.getProductId(),
                    record.getProductName(),
                    record.getCategory(),
                    record.getPrice(),
                    record.getQuantity()
                };
                model.addRow(row);
                
                int count =0;
                for(String product : product_list)
                {
                  if (product.compareTo(record.getProductName()) == 0)
                  {
                    count++;
                  }
                }                
                if(count == 0)
                    product_list.add(record.getProductName());
            }
             
            for(String product : product_list)
            {
               product_box.addItem(product);
            }
        }        
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}
