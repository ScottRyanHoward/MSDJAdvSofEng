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
import main.structures.Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matt HP
 */
public class UserManagerThreadWorker extends SwingWorker<DefaultTableModel, ArrayList<Employee>>
{

    //initialize varibles
    ArrayList<Employee> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;

    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;

    public UserManagerThreadWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos, DefaultTableModel new_model, ArrayList<Employee> new_list)
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
        Callable<ArrayList<Employee>> load_product_task = new Callable<ArrayList<Employee>>()
        {
            @Override
            public ArrayList<Employee> call() throws Exception
            {
                return loadEmployee();
            }

            private ArrayList<Employee> loadEmployee()
            {

                ArrayList<Employee> albums = new ArrayList();
                try
                {
                    albums = (ArrayList<Employee>) ios.readObject();
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
        final CompletionService<ArrayList<Employee>> service
                = new ExecutorCompletionService<>(exec);

        service.submit(load_product_task);
        final Future<ArrayList<Employee>> future = service.take();
        publish(future.get());

        exec.shutdown();
        return model;
    }

    @Override
    protected void process(List<ArrayList<Employee>> chunks)
    {
        for (Employee record : chunks.get(0))
        {
            System.out.println(record.getEmployeeId());
            Object[] row =
            {
                record.getEmployeeId(),
                record.getFirstName(),
                record.getLastName(),
                record.getAddress(),
                record.getSsn(),
                record.getHours(),
                record.getWage(),
            //              record.getAccountPassword(),
            //              record.getIsAdmin()
            };
            model.addRow(row);
            boolean found = false;
            for(Employee list_record : list)
            {              
              if(list_record.getEmployeeId() == record.getEmployeeId())
              {
                break;
              }
            }
            if(!found)
                list.add(record);
        }
        
        
    }

    @Override
    public void done()
    {
        System.out.println("Done");
    }
}
