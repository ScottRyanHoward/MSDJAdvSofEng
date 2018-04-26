/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.interfaces.TransactionInterface_I;
import main.structures.Transaction;
import main.structures.Purchased;

/**
 *
 * @author Matt HP
 */
public class TransactionImpl implements TransactionInterface_I
{
    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;

    public TransactionImpl(ObjectInputStream input_stream, ObjectOutputStream output_stream)
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
    public void addTransaction(Transaction new_transaction)
    {    
            String query = "INSERT INTO transaction (transaction_id, transaction_date, total, payment_type, tax) VALUES (" +
            "'" + new_transaction.getTransactionId() + "' ," +
            "'" + new_transaction.getTransactionDate()+ "' ," +
            "'" + new_transaction.getTotal() + "' ," +
            "'" + new_transaction.getPaymentType() + "' ," +
            "'" + new_transaction.getTax()+"' )" ;
          executeSql(query);
    }
    
    @Override
    public void addPurchase(Purchased new_purchase)
    {  
            String query = "INSERT INTO purchased_in (transaction_id, product_id, product_price, amount_purchased) VALUES (" +
            "'" + new_purchase.getTransID() + "' ," +
            "'" + new_purchase.getProdID() + "' ," +
            "'" + new_purchase.getPrice() + "' ," +
            "'" + new_purchase.getQuantity()+"' );" ;
            
            String update = " UPDATE Product " +
                            "SET quantity = quantity - 1 " +
                            "WHERE product_id = '" +new_purchase.getProdID() +
                            "' and quantity > 0;";
                                
            executeSql(query);   
            executeSql(update); 
    }    
}