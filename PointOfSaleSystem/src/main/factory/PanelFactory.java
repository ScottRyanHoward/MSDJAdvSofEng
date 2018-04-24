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
import main.implementation.EmployeeImpl;
import main.implementation.InventoryImpl;
import main.implementation.SalesImpl;
import main.implementation.TransactionImpl;
import main.interfaces.Employee_I;
import main.interfaces.InventoryInterfaceForManagers_I;
import main.interfaces.Login_I;
import main.interfaces.SalesInterface_I;
import main.interfaces.TransactionInterface_I;

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
   
   private ObjectInputStream sales_product_ios = null;
   private ObjectOutputStream sales_product_oos = null;
   private Socket sales_product_socket;
   private SalesInterface_I sales_product_accessor;

   
   private main.gui.core.UserManagementPanel userManagementPanel;
   private ObjectInputStream user_ios = null;
   private ObjectOutputStream user_oos = null;
   private Employee_I employee_accessor;
   private Socket user_socket;   
   
   private main.gui.core.LoginPanel loginPanel;
   private ObjectInputStream login_ios = null;
   private ObjectOutputStream login_oos = null;
   private Socket login_socket;   
   private Login_I login_accessor;
   
   private main.gui.core.TransactionsPanel transactionPanel;
   private ObjectInputStream transaction_ios = null;
   private ObjectOutputStream transaction_oos = null;
   private Socket transaction_socket;   
   private TransactionInterface_I transaction_accessor;
   private InventoryInterfaceForManagers_I transaction_inventory_accessor;

   private main.gui.core.LauncherMenuPanel launcherMenuPanel;
   
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
      this.sales_product_socket = new Socket("127.0.0.1", 2000);
      this.sales_product_ios = new ObjectInputStream(this.sales_product_socket.getInputStream());
      this.sales_product_oos = new ObjectOutputStream(this.sales_product_socket.getOutputStream());
      this.sales_product_accessor = new SalesImpl(this.sales_product_ios, this.sales_product_oos);

      this.salesMetricsPanel = new main.gui.core.SalesMetricsPanel(sales_accessor,sales_socket, sales_oos,sales_ios,
                                                                   sales_product_accessor,sales_product_socket, sales_product_oos,sales_product_ios);   
      
      //Usermanagement
      this.user_socket = new Socket("127.0.0.1", 2000);
      this.user_ios = new ObjectInputStream(this.user_socket.getInputStream());
      this.user_oos = new ObjectOutputStream(this.user_socket.getOutputStream());
      this.employee_accessor = new EmployeeImpl(this.user_ios, this.user_oos);
      this.login_accessor = new EmployeeImpl(this.user_ios, this.user_oos);
      this.userManagementPanel = new main.gui.core.UserManagementPanel(employee_accessor,user_socket, user_oos,user_ios); 
      
      //Login
      this.login_socket = new Socket("127.0.0.1", 2000);
      this.login_ios = new ObjectInputStream(this.login_socket.getInputStream());
      this.login_oos = new ObjectOutputStream(this.login_socket.getOutputStream());
      this.login_accessor = new EmployeeImpl(this.login_ios, this.login_oos);
      this.loginPanel = new main.gui.core.LoginPanel(login_accessor,login_socket, login_oos,login_ios);  
      
      //Transaction 
      this.transaction_socket = new Socket("127.0.0.1", 2000);
      this.transaction_ios = new ObjectInputStream(this.transaction_socket.getInputStream());
      this.transaction_oos = new ObjectOutputStream(this.transaction_socket.getOutputStream());
      this.transaction_accessor = new TransactionImpl(this.transaction_ios, this.transaction_oos);
      this.transaction_inventory_accessor = new InventoryImpl(this.transaction_ios, this.transaction_oos);
      this.transactionPanel = new main.gui.core.TransactionsPanel(transaction_inventory_accessor,transaction_accessor,transaction_socket, transaction_oos,transaction_ios);  
          
      //launcher
      this.launcherMenuPanel = new main.gui.core.LauncherMenuPanel();
      
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
  
  public main.gui.core.LoginPanel getLoginPanel()
  {
     return this.loginPanel;
  }
  
  public main.gui.core.UserManagementPanel getUserManagementPanel()
  {
     return this.userManagementPanel;
  }

  public main.gui.core.LauncherMenuPanel getLauncherMenuPanel()
  {
    return this.launcherMenuPanel;
  }
  
  public main.gui.core.TransactionsPanel getTransactionsPanel()
  {
    return this.transactionPanel;
  }
}
