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
public class Transaction {
    
    private String trans_id;
    private String date;
    private double total;
    private double tax;
    private String payment;
    
    public Transaction()
    {
        trans_id = "";
        date = "";
        total = 0.00;
        tax = 0.00;
        payment = "";
    }
    
    public String getTransID()
    {
        return trans_id;
    }

    public void setTransID(String trans_id)
    {
        this.trans_id = trans_id;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public double getTotal()
    {
        return total;
    }
    
    public void setTotal(double total)
    {
        this.total = total;
    }
    
    public double getTax()
    {
        return tax;
    }
    
    public void setTax(double tax)
    {
        this.tax = tax;
    }
    
    public String getPayment()
    {
        return payment;
    }
    
    public void setPayment(String payment)
    {
        this.payment = payment;
    }
}
