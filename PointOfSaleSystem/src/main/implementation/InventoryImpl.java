/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
//import java.util.concurrent.Callable;

import main.structures.Product;

public class InventoryImpl implements main.interfaces.InventoryInterfaceForManagers_I //,Callable<ArrayList<Product>>
{
    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;


    public InventoryImpl(ObjectInputStream input_stream, ObjectOutputStream output_stream)
    {
        this.ios = input_stream;
        this.oos = output_stream;
    }

    @Override
    public void updateProduct(Product update_product_id, String original_product_id)
    {
        String query = "UPDATE Product " + "SET "
                + "product_id = " + update_product_id.getProductId() + ","
                + "product_name = " + update_product_id.getProductName() + ","
                + "description = " + update_product_id.getDescription() + ","
                + "price = " + update_product_id.getPrice() + ","
                + "size = " + update_product_id.getSize() + ","
                + "quantity = " + update_product_id.getQuantity() + ","
                + "category = " + update_product_id.getCategory()
                + "WHERE product_id = " + original_product_id;
      executeSql(query);
    }

    @Override
    public void updateProduct(Product update_product_id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProduct(Product new_product)
    {
        String query = "INSERT INTO Product (product_id, product_name, description,price,quantity,category) "
                + "VALUES ('" + new_product.getProductId() + "','" + new_product.getProductName() + "' ,'"
                + new_product.getDescription() + "' , '" + new_product.getPrice() + "','"
                + new_product.getQuantity() + "','" + new_product.getCategory() + "')";

         executeSql(query);
    }

    @Override
    public void deleteProduct(String product_id)
    {
        String query = "DELETE FROM Product "
                + "WHERE product_id = '" + product_id + "'";
        executeSql(query);
    }

    @Override
    public void getProduct(String product_id_number)
    {
        String query = "SELECT * FROM Product Where product_id = '" +
                    product_id_number + "'";
        executeSql(query);
    }

    @Override
    public void getAllProducts()
    {
      String query = "SELECT * FROM Product ";
      executeSql(query);
    }

    @Override
    public void searchProducts(String query)
    {
      executeSql(query);
    }
    
    public void executeSql(String query)
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
}
