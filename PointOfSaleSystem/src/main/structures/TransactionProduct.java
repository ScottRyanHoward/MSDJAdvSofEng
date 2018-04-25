/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

import java.io.Serializable;

/**
 *
 * @author Matt HP
 */
public class TransactionProduct implements Serializable
{
    
    private String product_id;
    private String product_name;
    private String category;
    private double price;
    private int quantity;
    private String transaction_id; 
    
    
    /**
     * 
     * @return the product_id
     */
    public String getTransactionId()
    {
        return transaction_id;
    }
  
        /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransacyionId(String transaction_id)
    {
        this.transaction_id = transaction_id;
    }
    
       /**
     * 
     * @return the product_id
     */
    public String getProductId()
    {
        return product_id;
    }
  
        /**
     * @param product_id the product id to set
     */
    public void setProductId(String product_id)
    {
        this.product_id = product_id;
    }

    /**
     * @return the product_name
     */
    public String getProductName()
    {
        return product_name;
    }

    /**
     * @param product_name the product_name to set
     */
    public void setProductName(String product_name)
    {
        this.product_name = product_name;
    }
    
    /**
    * @return the category
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category)
    {
        this.category = category;
    }

    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
   
}
