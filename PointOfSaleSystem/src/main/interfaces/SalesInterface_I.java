/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.interfaces;

import main.structures.Sales;
import java.util.ArrayList;
/**
 *
 * @author Matt HP
 */
public interface SalesInterface_I
{
   ArrayList<Sales> getSales(String transaction_id);
   ArrayList<Sales> getAllSales();
   ArrayList<Sales> searchSales(String query);
}
