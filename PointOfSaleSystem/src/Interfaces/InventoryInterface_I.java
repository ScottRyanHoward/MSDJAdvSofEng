package Interfaces;
import Structures.Product;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matt HP
 */
public interface InventoryInterface_I
{
   Product getProduct(String product_id_number);
   ArrayList<Product> getAllProducts();
   
}
