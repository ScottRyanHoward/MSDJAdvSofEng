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
import main.structures.Login;
import main.structures.Login;

/**
 *
 * @author Matt HP
 */
public class LoginWorker extends SwingWorker<Login, ArrayList<Login>>
{
    //initialize varibles
    ArrayList<Login> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;
    private Login login;

    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;

    public LoginWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, Login new_login)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
        this.login = new_login;
    }

    @Override
    protected Login doInBackground() throws Exception
    {
        Callable<ArrayList<Login>> load_product_task = new Callable<ArrayList<Login>>()
        {
            @Override
            public ArrayList<Login> call() throws Exception
            {
                return loadLogin();
            }

            private ArrayList<Login> loadLogin()
            {

                ArrayList<Login> albums = new ArrayList();
                try
                {
                    albums = (ArrayList<Login>) ios.readObject();
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
        final CompletionService<ArrayList<Login>> service
                = new ExecutorCompletionService<>(exec);

        service.submit(load_product_task);
        final Future<ArrayList<Login>> future = service.take();
        publish(future.get());

        exec.shutdown();
        return login;
    }

    @Override
    protected void process(List<ArrayList<Login>> chunks)
    {
        for (Login record : chunks.get(0))
        {
            login = new Login();
            login.setUsername(record.getUsername());
            login.setSuccessful(record.getSuccessful());
        }       
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}

