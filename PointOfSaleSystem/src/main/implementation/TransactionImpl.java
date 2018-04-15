/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import main.interfaces.DatabaseConnection_I;
import main.interfaces.TransactionInterface_I;
import main.structures.Transaction;
import main.structures.Purchased;

/**
 *
 * @author Matt HP
 */
public class TransactionImpl implements TransactionInterface_I
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
    public void addTransaction(Transaction new_transaction)
    {    
        try {
            
            connection = db_connection.connectToDatabase();

            String query = "INSERT INTO transaction (transaction_id, transaction_date, total, payment_type, tax) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, new_transaction.getTransID());
            preparedStatement.setString(2, new_transaction.getDate());
            preparedStatement.setDouble(3, new_transaction.getTotal());
            preparedStatement.setString(4, new_transaction.getPayment());
            preparedStatement.setDouble(5, new_transaction.getTax());
            preparedStatement.executeUpdate();
            
            connection.close();
            
            
//        String query = "INSERT INTO transaction (transaction_id, transaction_date, total, payment_type, tax) " +
//                "VALUE ('"
//                + new_transaction.getTransID() + "','"
//                + new_transaction.getDate() + "','"
//                + new_transaction.getTotal() + "','"
//                + new_transaction.getPayment() + "','"
//                + new_transaction.getTax() + "')'";
//        executeSqlStatement(query);
        } catch (SQLException e) {
            System.out.println("addTransaction " + e);
        }
    }
    
    @Override
    public void addPurchase(Purchased new_purchase)
    {        
        String query = "INSERT INTO puchased_in (transaction_id, product_id, price) " +
        "VALUE ('"
        + new_purchase.getTransID() + "','"
        + new_purchase.getProdID() + "','"
        + new_purchase.getPrice() + "')'";
    
        executeSqlStatement(query);
    }
    
    
    
}