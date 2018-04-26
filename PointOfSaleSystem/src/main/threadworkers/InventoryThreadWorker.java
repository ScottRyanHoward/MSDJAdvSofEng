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
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import main.structures.Product;

/**
 * description - used to start threads and update the gui
 *
 */
public class InventoryThreadWorker extends SwingWorker<DefaultTableModel, ArrayList<Product>>
{
    //initialize varibles
    ArrayList<Product> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;

    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;

    public InventoryThreadWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, DefaultTableModel new_model,ArrayList<Product> new_list)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
        this.model = new_model;
        this.list = new_list;
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
        for (Product record : chunks.get(0))
        {
            Object[] row =
            {
                record.getProductId(),
                record.getCategory(),
                record.getProductName(),
                record.getDescription(),
                record.getSize(),
                record.getPrice(),
                record.getQuantity(),

            };
            model.addRow(row);
            
            boolean found = false;
            if(!list.isEmpty())
            {
            for(Product list_record : list)
            {              
              if(list_record.getProductId().compareTo(record.getProductId())==0)
              {
                break;
              }
            }
            
            if(!found)
                list.add(record);
        }
        }
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}
