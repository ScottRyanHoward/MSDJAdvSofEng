/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.util.ArrayList;

import main.interfaces.DatabaseConnection_I;
import main.structures.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InventoryImpl implements main.interfaces.InventoryInterfaceForManagers_I
{
    private Connection connection;
    private DatabaseConnection_I db_connection = new DatabaseConnectionImpl();

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
    public void updateProduct(Product update_product_id, String original_product_id)
    {        
        String query = "UPDATE Product "  + "SET " +
        "product_id = " + update_product_id.getProductId() + "," +
        "product_name = " + update_product_id.getProductName() + "," +
        "description = " + update_product_id.getDescription() + "," +
        "price = " + update_product_id.getPrice() + "," +
        "quantity = " + update_product_id.getQuantity() + "," +
        "category = " +  update_product_id.getCategory().name() + 
        "WHERE product_id = " + original_product_id;
        executeSqlStatement(query);
    }

    @Override
    public void addProduct(Product new_product)
    {
       String query = "INSERT INTO Product (product_id, product_name, description,price,quantity,category) " +
       "VALUES (" + new_product.getProductId() + "," + new_product.getProductName() + " ," +
        new_product.getDescription() + " , " + new_product.getPrice() + "," + 
        new_product.getQuantity() + "," + new_product.getCategory().name() + ")";
       
        executeSqlStatement(query);
    }

    @Override
    public void deleteProduct(String product_id)
    {
        String query = "DELETE FROM Product " +
        "WHERE product_id = " + product_id;                
      
        executeSqlStatement(query);
    }

    @Override
    public Product getProduct(String product_id_number)
    {
        Product product = new Product();
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM Product ";
            ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
                while (result.next())
                {
                    product.setProductId(result.getString("product_id"));
                    product.setProductName(result.getString("product_name"));
                    product.setDescription(result.getString("description"));
                    product.setCategory((Product.Category.values())[Integer.parseInt(result.getString("category"))]);
                    product.setPrice(Double.parseDouble(result.getString("price")));
                    product.setQuantity(Integer.parseInt(result.getString("quantity")));
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getProduct " + e);
        }
        return product;
    }

    @Override
    public ArrayList<Product> getAllProducts()
    {
         
        ArrayList<Product> product_list = new ArrayList();
        
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM Product ";
            ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
                while (result.next())
                {
                    Product product = new Product();
                    product.setProductId(result.getString("product_id"));
                    product.setProductName(result.getString("product_name"));
                    product.setDescription(result.getString("description"));
                    product.setCategory((Product.Category.values())[Integer.parseInt(result.getString("category"))]);
                    product.setPrice(Double.parseDouble(result.getString("price")));
                    product.setQuantity(Integer.parseInt(result.getString("quantity")));
                    product_list.add(product);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getAllProducts " + e);
        }
        return product_list;
    }
}
