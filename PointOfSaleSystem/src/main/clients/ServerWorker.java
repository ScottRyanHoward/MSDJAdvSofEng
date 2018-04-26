/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.clients;

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
 *
 * @author Matt HP
 */
public class ServerWorker extends SwingWorker<Integer, Integer>
{

    //initialize varibles
    ArrayList<Product> list = new ArrayList();
    private ObjectInputStream ios = null;
    private ObjectOutputStream oos = null;
    private Socket s;
    
    DefaultTableModel model;
    //Executor service
    private ExecutorService exec;
    
    public ServerWorker(Socket new_socket, ObjectInputStream new_ios,
            ObjectOutputStream new_oos)
    {
        this.ios = new_ios;
        this.oos = new_oos;
        this.s = new_socket;
    }

    @Override
    protected Integer doInBackground() throws Exception
    {

   /*     while(s.isConnected())
        {
    //       Thread connThread = new Thread(new ConnectionCW(s, ios.readObject().toString())
            {
               
            });
   //         connThread.start();
            }*/
        return 0;
    }      
}

