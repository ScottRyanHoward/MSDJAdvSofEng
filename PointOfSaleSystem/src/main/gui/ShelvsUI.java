package main.gui;

import java.awt.CardLayout;
import main.factory.PanelFactory;
import main.implementation.InventoryImpl;
import main.interfaces.InventoryInterfaceForManagers_I;
import main.interfaces.InventoryInterface_I;
import main.implementation.EmployeeImpl;
import main.implementation.SalesImpl;
import main.interfaces.Employee_I;
import main.interfaces.Login_I;
import main.interfaces.SalesInterface_I;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeremy
 * @author Dakota Pollitt
 */
public class ShelvsUI extends javax.swing.JFrame {

    boolean admin_token;

    Employee_I employee_handler = new EmployeeImpl();
    
    /**
     * Creates new form LoginGUI
     */
    public ShelvsUI(boolean in_admin_token) {
        admin_token = in_admin_token;
        initComponents();
    }
    
    public void setAdmin(boolean is_admin)
    {
       admin_token = is_admin;
    }

    @SuppressWarnings("unchecked")                      
    private void initComponents()
    {
        factory = new PanelFactory(true);
        shelvsPanel = new javax.swing.JPanel();
        launcherMenuPanel = new main.gui.core.LauncherMenuPanel();
        transactionsPanel = new main.gui.core.TransactionsPanel();
        
        userManagementPanel = new main.gui.core.UserManagementPanel(employee_handler);
        loginPanel = new main.gui.core.LoginPanel( (Login_I)employee_handler );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        shelvsPanel.setPreferredSize(new java.awt.Dimension(1878, 1038));
        shelvsPanel.setLayout(new java.awt.CardLayout());
        shelvsPanel.add(loginPanel, "loginPanel");
        shelvsPanel.add(launcherMenuPanel, "launcherMenuPanel");
        shelvsPanel.add(factory.getInventoryPanel(), "inventoryManagementPanel");
        shelvsPanel.add(transactionsPanel, "transactionsPanel");
        shelvsPanel.add(factory.getSalesPanel(), "salesMetricsPanel");
        shelvsPanel.add(userManagementPanel, "userManagementPanel");
 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shelvsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shelvsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShelvsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShelvsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShelvsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShelvsUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShelvsUI(false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private PanelFactory factory;
    private main.gui.core.LauncherMenuPanel launcherMenuPanel;
    private main.gui.core.LoginPanel loginPanel;
    private javax.swing.JPanel shelvsPanel;
    private main.gui.core.TransactionsPanel transactionsPanel;
    private main.gui.core.UserManagementPanel userManagementPanel;
    private SalesInterface_I sales_interface;
    // End of variables declaration                   
}
