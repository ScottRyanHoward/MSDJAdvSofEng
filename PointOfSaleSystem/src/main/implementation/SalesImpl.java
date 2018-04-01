/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

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

    private Connection connection;
    private DatabaseConnection_I db_connection;

    public SalesImpl(DatabaseConnection_I input_db_connection)
    {
        db_connection = input_db_connection;
    }

    private void executeSqlStatement(String sql_statement)
    {
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            statement.execute(sql_statement);
        }
        catch (SQLException e)
        {
            System.out.println("updateProduct " + e);
        }
    }

    @Override
    public ArrayList<Sales> getSales(String transaction)
    {
        ArrayList<Sales> sales_list = new ArrayList();

        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM sales Where transaction_id = ' "
                    + transaction + "'";
            ResultSet result = statement.executeQuery(command);

            if (null != result)
            {
                while (result.next())
                {
                    Sales sales = new Sales();
                    sales.setDate(result.getString("date"));
                    sales.setPrice(Double.parseDouble(result.getString("price")));
                    sales.setProductId(result.getString("product_id"));
                    sales.setQuantity(Integer.parseInt(result.getString("quantity")));
                    sales.setTransactionId(result.getString("transaction_id"));
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getSales " + e);
        }
        return sales_list;
    }
    
    @Override
    public ArrayList<Sales> getAllSales()
    {
        ArrayList<Sales> sales_list = new ArrayList();

        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM sales ";
            ResultSet result = statement.executeQuery(command);

            if (null != result)
            {
                while (result.next())
                {
                    Sales sales = new Sales();
                    sales.setDate(result.getString("date"));
                    sales.setPrice(Double.parseDouble(result.getString("price")));
                    sales.setProductId(result.getString("product_id"));
                    sales.setQuantity(Integer.parseInt(result.getString("quantity")));
                    sales.setTransactionId(result.getString("transaction_id"));
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getSales " + e);
        }
        return sales_list;
    }

    public ArrayList<Sales> searchSales(String query)
    {
        ArrayList<Sales> sales_list = new ArrayList();
        return sales_list;
    }
}
