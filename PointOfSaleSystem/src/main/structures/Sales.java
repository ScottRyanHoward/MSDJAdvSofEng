/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

/**
 *
 * @author Matt HP
 */
public class Sales
{

    private String date;
    private String time;
    private String product_id;
    private String transaction_id;
    private int quantity;
    private double price;
    
    /**
     *
     */
    public Sales()
    {
      date = "";
      time = "";
      product_id = "";
      quantity = 0;
      price = 0.00;
    }
    
    /**
     * @return the date
     */
    public String getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime()
    {
        return time;
    }

    /**
     * @param Time the time to set
     */
    public void setTime(String Time)
    {
        this.time = Time;
    }

    /**
     * @return the product_id
     */
    public String getProductId()
    {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProductId(String product_id)
    {
        this.product_id = product_id;
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
    public void setPrice(Double price)
    {
        this.price = price;
    }

    /**
     * @return the transaction_id
     */
    public String getTransactionId()
    {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransactionId(String transaction_id)
    {
        this.transaction_id = transaction_id;
    }
}
