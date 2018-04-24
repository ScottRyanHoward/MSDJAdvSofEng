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

import java.io.Serializable;

public class Transaction implements Serializable
{
    private String transaction_date;
    private double total;
    private String payment_type;
    private double tax;
    private String transaction_id;
    
    /**
     *
     */
    public Transaction()
    {
      transaction_id = "";
      transaction_date = "";
      payment_type = "";
      total = 0.00;
      tax = 0.00;
    }
    
    /**
     * @return the date
     */
    public String getTransactionId()
    {
        return transaction_id;
    }

    /**
     * @param date the date to set
     */
    public void setTransactionId(String transaction_id)
    {
        this.transaction_id = transaction_id;
    }


        /**
     * @return the date
     */
    public String getTransactionDate()
    {
        return transaction_date;
    }

    /**
     * @param date the date to set
     */
    public void setTransactionDate(String transaction_date)
    {
        this.transaction_date = transaction_date;
    }

            /**
     * @return the date
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * @param date the date to set
     */
    public void setTotal(double total)
    {
        this.total = total;
    }
    
    /**
     * @return the date
     */
    public String getPaymentType()
    {
        return payment_type;
    }

    /**
     * @param date the date to set
     */
    public void setPaymentType(String new_payment)
    {
        this.payment_type = new_payment;
    }
    
                /**
     * @return the date
     */
    public double getTax()
    {
        return tax;
    }

    /**
     * @param date the date to set
     */
    public void setTax(double tax)
    {
        this.tax = tax;
    }
}
