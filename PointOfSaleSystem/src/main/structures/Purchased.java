/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

/**
 *
 * @author Jeremy
 */
public class Purchased {
    
    private String prod_id;
    private String trans_id;
    private double price;
    private int quantity;
    
    public Purchased()
        {
            prod_id = "";
            trans_id = "";
            price = 0.00;
            quantity = 0;
        }
    
    public String getProdID()
    {
        return prod_id;
    }
    
    public void setProdID(String prod_id)
    {
        this.prod_id = prod_id;
    }
    
    public String getTransID()
    {
        return trans_id;
    }

    public void setTransID(String trans_id)
    {
        this.trans_id = trans_id;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }    
    
    
}
