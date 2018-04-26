/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.interfaces;

import main.structures.Transaction;
import main.structures.Purchased;

/**
 *
 * @author Jeremy
 */
public interface TransactionInterface_I {
   public void addTransaction(Transaction new_transaction);
   public void addPurchase(Purchased new_purchase);
}
