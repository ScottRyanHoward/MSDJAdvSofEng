/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.clients;

import java.io.*;
import java.util.*;
import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.structures.Employee;
import main.structures.Product;
import main.structures.Transaction;
import main.structures.TransactionProduct;

class ConnectionCW implements Runnable
{

    private Socket s;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    ConnectionCW(Socket s)
    {
        this.s = s;
        setupStreams();
    }

    private void setupStreams()
    {
        try
        {
            output = new ObjectOutputStream(s.getOutputStream());
            output.flush();
            input = new ObjectInputStream(s.getInputStream());
            System.out.println("Streams are now set up");
        }
        catch (IOException e)
        {
            System.out.println("IOEXCEPTION " + e);
        }
    }

    public void run()
    {
        try
        {
           while (s.isConnected())
           {
            String str = input.readObject().toString();
           System.out.println(str);
           this.queryDatabase(str);
           }
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConnectionCW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  // end of method run*/

    public void queryDatabase(String query) throws Exception
    {
        try
        {
            Connection conn = connectToDatabase();
            Statement statement = conn.createStatement();
            if(query.contains("Select") ||
                query.contains("SELECT"))
            {
              processSelectQuery(statement, query);
              System.out.println("WRITING DATA");
            }
            
            else
            {
               statement.execute(query);               
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        finally
        {
            System.out.println("Function complete!");
        }
    }

    private void processSelectQuery(Statement statement, String query)
    {
       try
       {
        ResultSet result = statement.executeQuery(query);
        
        
        if (query.contains("purchased_in"))
        {
           packAndSendProductsPurchased(result);
        }
        else if(query.contains("Product"))
        {
           packAndSendProductResults(result);
        }
        else if(query.contains("Employee"))
        {
           packAndSendEmployeeResults(result);
        }
        
        else if(query.contains("transaction"))
        {
           packAndSendTransactionResults(result);
        }   
  
        
       }
       catch(SQLException e)
       {
       
       }
    }
    private void packAndSendProductResults(ResultSet result)
    {
        ArrayList<Product> product_list = new ArrayList();
        try
        {
            if (null != result)
            {
                while (result.next())
                {
                    Product product = new Product();
                    product.setProductId(result.getString("product_id"));
                    product.setProductName(result.getString("product_name"));
                    product.setDescription(result.getString("description"));
                    product.setCategory(result.getString("category"));
                    product.setSize(result.getString("size"));
                    product.setPrice(Double.parseDouble(result.getString("price")));
                    product.setQuantity(Integer.parseInt(result.getString("quantity")));
                    product_list.add(product);
                }
            }
        
            output.writeObject(product_list);
            output.flush();
        }
        catch (SQLException | IOException e)
        {
        }
    }
    
    private void packAndSendProductsPurchased(ResultSet result)
    {
        ArrayList<TransactionProduct> product_list = new ArrayList();
        try
        { 
            if (null != result)
            {

                while (result.next())
                {
                    TransactionProduct product = new TransactionProduct();
                    product.setTransacyionId(result.getString("purchased_in.transaction_id"));
                    product.setProductId(result.getString("purchased_in.product_id"));
                    product.setProductName(result.getString("Product.product_name"));
                    product.setCategory(result.getString("Product.category"));
                    product.setPrice(Double.parseDouble(result.getString("purchased_in.product_price")));
                    product.setQuantity(Integer.parseInt(result.getString("purchased_in.amount_purchased")));
                    product_list.add(product);
                }
            }
        
            output.writeObject(product_list);
            output.flush();
        }
        catch (SQLException | IOException e)
        {
            System.out.println(e);
        }
    }
    
    
    private void packAndSendEmployeeResults(ResultSet result)
    {
        ArrayList<Employee> employee_list = new ArrayList();
        try
        {
            if (null != result)
            {
                while (result.next())
                {
                    Employee employee = new Employee();
                    employee.setAccountPassword(result.getString("account_password"));
                    employee.setAddress(result.getString("address"));
                    employee.setEmployeeId(result.getString("employee_id"));
                    employee.setFirstName(result.getString("first_name"));
                    employee.setLastName(result.getString("last_name"));
                    employee.setHours(Double.parseDouble(result.getString("hours")));
                    employee.setIsAdmin(Boolean.parseBoolean(result.getString("is_admin")));
                    employee.setWage(Double.parseDouble(result.getString("wage")));
                    employee.setSsn(Integer.parseInt(result.getString("ssn")));
                    employee_list.add(employee);
                }
            }
            output.writeObject(employee_list);
            output.flush();
        }
        catch (SQLException | IOException e)
        {
        }
    }

    private void packAndSendTransactionResults(ResultSet result)
    {
        System.out.println("packAndSendTransactionResults");
        
        ArrayList<Transaction> transaction_list = new ArrayList();
        try
        {
            if (null != result)
            {
                while (result.next())
                {
                    Transaction transaction = new Transaction();
                    transaction.setPaymentType(result.getString("payment_type"));
                    transaction.setTransactionId(result.getString("transaction_id"));
                    transaction.setTotal(Double.parseDouble(result.getString("total")));
                    transaction.setTransactionDate(result.getString("transaction_date"));
                    transaction.setTax(Double.parseDouble(result.getString("tax")));
                    transaction_list.add(transaction);
                }
            }
            
            output.writeObject(transaction_list);
            output.flush();
        }
        catch (SQLException | IOException e)
        {
        }
    }   
    
    public Connection connectToDatabase() throws SQLException
    {
        Connection con;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            System.err.println("Unable to load MySQL Driver");
        }
        try
        {
            String url = "jdbc:mysql://localhost:3306/pos_system";

            con = DriverManager.getConnection(url, "root", "MSDJ");

       //     System.out.println("Connected!");
            return con;
        }

        catch (SQLException e)
        {
            System.err.println("Unable to load MySQL Driver");
            System.err.println(e);

        }
        return null;
    }

}
