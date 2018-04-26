/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.interfaces.DatabaseConnection_I;
import main.interfaces.SalesInterface_I;
import main.structures.Sales;

/**
 *
 * @author Matt HP
 */
public class SalesImpl implements SalesInterface_I
{

    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;

    public SalesImpl(ObjectInputStream input_stream, ObjectOutputStream output_stream)
    {
        this.ios = input_stream;
        this.oos = output_stream;    
    }

    private void executeSql(String query)
    {
       try
        {
            System.out.println("QUERY = " + query);
            oos.writeObject(query);
            oos.flush();
        }
        catch (IOException e)
        {
            System.out.println (e);
        }
    }

    @Override
    public void getSales(String transaction)
    {
        String query = "SELECT * FROM transaction Where transaction_id = ' " +
                transaction +"'";
        executeSql(query);
    }
    
    @Override
    public void getAllSales()
    {
        String query = "SELECT * FROM transaction ";
        executeSql(query);
    }

    public void searchSales(String query)
    {
        executeSql(query);
    }
}
