/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Structures.Product;

/**
 *
 * @author Matt HP
 */
public interface InventoryInterfaceForManagers_I extends InventoryInterface_I
{
    public void updateProduct(Product update_product_id, String orignal_product_id);
    public void addProduct(Product new_product);
    public void deleteProduct(String product_id);
}
