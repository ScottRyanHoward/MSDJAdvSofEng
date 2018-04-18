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
import main.structures.Transaction;

/**
 * description - used to start threads and update the gui
 *
 */
public class SalesThreadWorker extends SwingWorker<DefaultTableModel, ArrayList<Transaction>>
{
    //initialize varibles
    ArrayList<Transaction> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;

    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;

    public SalesThreadWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, DefaultTableModel new_model)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
        this.model = new_model;
    }

    @Override
    protected DefaultTableModel doInBackground() throws Exception
    {
        Callable<ArrayList<Transaction>> load_product_task 
                = new Callable<ArrayList<Transaction>>()
        {
            @Override
            public ArrayList<Transaction> call() throws Exception
            {
                System.out.println("Transaction CALL FUNCTION");
                return loadTransaction();
            }

            private ArrayList<Transaction> loadTransaction()
            {

                ArrayList<Transaction> albums = new ArrayList();
                try
                {
                    albums = (ArrayList<Transaction>) ios.readObject();

                    for (Transaction record : albums)
                    {
                        System.out.println(record.getTransactionId());
                    }
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
        final CompletionService<ArrayList<Transaction>> service
                = new ExecutorCompletionService<>(exec);

        service.submit(load_product_task);
        final Future<ArrayList<Transaction>> future = service.take();
        publish(future.get());

        exec.shutdown();
        return model;
    }

    @Override
    protected void process(List<ArrayList<Transaction>> chunks)
    {
        System.out.println("Process");
        for (Transaction record : chunks.get(0))
        {
            Object[] row =
            {
                record.getTransactionDate(),
                "",
                "",
                "",
                "",
                record.getTransactionId()
            };
            model.addRow(row);
        }
        //     ios.close();
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}
