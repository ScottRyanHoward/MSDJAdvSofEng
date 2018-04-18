/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.factory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import main.gui.core.InventoryManagementPanel;
import main.implementation.InventoryImpl;
import main.implementation.SalesImpl;
import main.interfaces.InventoryInterfaceForManagers_I;
import main.interfaces.SalesInterface_I;

/**
 *
 * @author Matt HP
 */
public class PanelFactory
{
    
   private main.gui.core.InventoryManagementPanel inventoryManagementPanel;
   private InventoryInterfaceForManagers_I inventory_accessor;
   private ObjectInputStream inventory_ios = null;
   private ObjectOutputStream inventory_oos = null;
   private Socket inventory_socket;

   private main.gui.core.SalesMetricsPanel salesMetricsPanel;
   private ObjectInputStream sales_ios = null;
   private ObjectOutputStream sales_oos = null;
   private SalesInterface_I sales_accessor;
   private Socket sales_socket;   
   
  public PanelFactory(boolean admin)
  {
    try
    {
      
      //inventory
      this.inventory_socket = new Socket("127.0.0.1", 2000);
      this.inventory_ios = new ObjectInputStream(this.inventory_socket.getInputStream());
      this.inventory_oos = new ObjectOutputStream(this.inventory_socket.getOutputStream());
      this.inventory_accessor = new InventoryImpl(this.inventory_ios, this.inventory_oos);
      this.inventoryManagementPanel = new main.gui.core.InventoryManagementPanel(true,inventory_accessor,inventory_socket,inventory_oos,inventory_ios);
      
      //sales
       this.sales_socket = new Socket("127.0.0.1", 2000);
      this.sales_ios = new ObjectInputStream(this.sales_socket.getInputStream());
      this.sales_oos = new ObjectOutputStream(this.sales_socket.getOutputStream());
      this.sales_accessor = new SalesImpl(this.sales_ios, this.sales_oos);
      this.salesMetricsPanel = new main.gui.core.SalesMetricsPanel(sales_accessor,sales_socket, sales_oos,sales_ios);   
      
    }
    catch(IOException e)
    {
      System.out.println("SERVER NOT RUNNING " + e);
    }
  }
  
  public main.gui.core.InventoryManagementPanel getInventoryPanel()
  {
     return this.inventoryManagementPanel;
  }
  
  public main.gui.core.SalesMetricsPanel getSalesPanel()
  {
     return this.salesMetricsPanel;
  }
}
