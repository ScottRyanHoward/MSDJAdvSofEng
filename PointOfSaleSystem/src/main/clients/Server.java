/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.clients;

import java.io.*;
import java.util.*;
import java.net.*;

public class Server 
 {

public static void main(String[] args) throws Exception
{
    int connectionCount = 0;  // Count of clients connecting
    Thread connThread;
    System.out.println("Server starting");
    ArrayList <Socket> sockets = new ArrayList();

    try
    {
        ServerSocket server = new ServerSocket(2000);
        while (true)
        {
            Socket new_socket = server.accept();
            sockets.add(new_socket);
            // Network n;
            connectionCount++;
            System.out.println("Connection " + connectionCount + " made");
  
            //Create and start thread to process client requests
            connThread = new Thread(new ConnectionCW(new_socket)
            {
               
            });
            connThread.start();
        }
    } catch (IOException e)
    {
        System.out.println("Trouble making a connection" + e);
    }
}
}
