/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.gui.core;

import java.awt.CardLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import main.interfaces.InventoryInterfaceForManagers_I;
import main.interfaces.InventoryInterface_I;
import main.structures.Product;
import main.threadworkers.InventoryThreadWorker;

/**
 *
 * @author Dakota
 */
public class InventoryManagementPanel extends javax.swing.JPanel
{
    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;
    private InventoryInterfaceForManagers_I inventory_accessor;
    private boolean admin_token;
    Product product = new Product();
    DefaultTableModel model;
    TableRowSorter<TableModel> tr; 
    ArrayList<Product>  product_list = new ArrayList();
    ArrayList<Product> search_product_list;
    InventoryThreadWorker worker;
    private Socket s;

    
    /**
     * Creates new form InventoryManagementPanel
     * @param in_admin_token
     * @param in_inventory_accessor
     * @param s
     */
    public InventoryManagementPanel(boolean in_admin_token,InventoryInterfaceForManagers_I in_inventory_accessor, 
              Socket s, ObjectOutputStream new_oos , ObjectInputStream new_ios)
    {
        admin_token = in_admin_token;
        inventory_accessor = in_inventory_accessor;

        oos = new_oos;
        ios = new_ios;
        initComponents();
        model = new DefaultTableModel(){
            //@Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        model.addColumn("Id");
        model.addColumn("Category"); 
        model.addColumn("Product Name"); 
        model.addColumn("Description"); 
        model.addColumn("Size");
        model.addColumn("Price");
        model.addColumn("Quantity");   
        
        product_jtable.setModel(model);
        
        tr = new TableRowSorter<TableModel>(model);
        
        product_jtable.setRowSorter(tr);
        product_jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        product_jtable.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                  updateProductTab();
                }
            });
         
       inventory_accessor.getAllProducts();
       threadRecipt();
    }
   
    private void updateProductTab()
    {
        if( !product_jtable.getSelectionModel().isSelectionEmpty())
        {
        product_id_textfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 0).toString());
        category_jtextfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 1).toString());
        product_name_textfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 2).toString());
        description_jtextarea.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 3).toString());
        size_jtextfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 4).toString());
        price_jtextfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 5).toString());
        quantity_jtextfield.setText(product_jtable.getValueAt(product_jtable.getSelectedRow(), 6).toString());
        }
    }
   
    private void showAllInventory()
    {
        System.out.println("Enter showAllInventory");
        ((DefaultTableModel) product_jtable.getModel()).setNumRows(0);
        if(product_list != null)
        {
             product_list.clear();
        }
        inventory_accessor.getAllProducts();
        threadRecipt();
        
        System.out.println("Leaving showAllInventory");

    }
    
   private void searchForProducts()
    {
        String query = "Select * From Product Where ";
        String id = search_product_id_textfield.getText();
        String name = search_product_name_jtextfield.getText();      
        
        if (id.length() == 0 &&
            name.length() ==0)
        {
           showAllInventory();
        }
        else
        {
            if(id.length() > 0)
            {
              //query += "product_id LIKE '%" + id  + "'";
              query += "product_id LIKE '%" + id + "%'";
            }
            if(name.length() > 0)
            {
              if (id.length() > 0)
                  query += " OR ";
              query += "product_name LIKE '%" + name + "%'";
            }

            ((DefaultTableModel)product_jtable.getModel()).setRowCount(0);
             inventory_accessor.searchProducts(query);
             product_jtable.clearSelection();
             threadRecipt();
        }         
    }
   
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        logo_jpanel = new javax.swing.JPanel();
        loco_icon_panel = new javax.swing.JPanel();
        logo_jlabel = new javax.swing.JLabel();
        company_name_label = new javax.swing.JLabel();
        option_jtabbedpane = new javax.swing.JTabbedPane();
        search_jpanel = new javax.swing.JPanel();
        search_product_name_jtextfield = new javax.swing.JTextField();
        search_product_id_textfield = new javax.swing.JTextField();
        search_jbutton = new javax.swing.JButton();
        javax.swing.JLabel search_product_name_label = new javax.swing.JLabel();
        search_product_id_label = new javax.swing.JLabel();
        product_jpanel = new javax.swing.JPanel();
        icon_jpanel = new javax.swing.JPanel();
        icon_jLabel = new javax.swing.JLabel();
        product_jlabel = new javax.swing.JLabel();
        product_name_jbutton = new javax.swing.JLabel();
        product_id_textfield = new javax.swing.JTextField();
        product_name_textfield = new javax.swing.JTextField();
        quantity_jlabel = new javax.swing.JLabel();
        quantity_jtextfield = new javax.swing.JTextField();
        price_jlabel = new javax.swing.JLabel();
        price_jtextfield = new javax.swing.JTextField();
        category_jlabel = new javax.swing.JLabel();
        category_jtextfield = new javax.swing.JTextField();
        description_jlabel = new javax.swing.JLabel();
        description_jscrollpane = new javax.swing.JScrollPane();
        description_jtextarea = new javax.swing.JTextArea();
        size_label = new javax.swing.JLabel();
        size_jtextfield = new javax.swing.JTextField();
        button_panel = new javax.swing.JPanel();
        transaction_jbutton = new javax.swing.JButton();
        admin_jbutton = new javax.swing.JButton();
        menu_jbutton = new javax.swing.JButton();
        add_to_cart_jbutton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        product_jtable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        add_product_button = new javax.swing.JButton();
        if(admin_token)
        {
            add_product_button.setEnabled(true);
        }
        else
        add_product_button.setEnabled(false);
        jButton1 = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1878, 1038));

        logo_jpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        loco_icon_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        logo_jlabel.setText("LOGO");

        javax.swing.GroupLayout loco_icon_panelLayout = new javax.swing.GroupLayout(loco_icon_panel);
        loco_icon_panel.setLayout(loco_icon_panelLayout);
        loco_icon_panelLayout.setHorizontalGroup(
            loco_icon_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loco_icon_panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(logo_jlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loco_icon_panelLayout.setVerticalGroup(
            loco_icon_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loco_icon_panelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(logo_jlabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        company_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        company_name_label.setText("COMPANY NAME");

        javax.swing.GroupLayout logo_jpanelLayout = new javax.swing.GroupLayout(logo_jpanel);
        logo_jpanel.setLayout(logo_jpanelLayout);
        logo_jpanelLayout.setHorizontalGroup(
            logo_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logo_jpanelLayout.createSequentialGroup()
                .addComponent(loco_icon_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(company_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        logo_jpanelLayout.setVerticalGroup(
            logo_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logo_jpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loco_icon_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(logo_jpanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(company_name_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        search_product_id_textfield.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                search_product_id_textfieldActionPerformed(evt);
            }
        });

        search_jbutton.setText("Search");
        search_jbutton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                search_jbuttonActionPerformed(evt);
            }
        });

        search_product_name_label.setText("Prodcut Name:");

        search_product_id_label.setText("Product Id :");

        javax.swing.GroupLayout search_jpanelLayout = new javax.swing.GroupLayout(search_jpanel);
        search_jpanel.setLayout(search_jpanelLayout);
        search_jpanelLayout.setHorizontalGroup(
            search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_jpanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_product_name_label)
                    .addComponent(search_product_id_label))
                .addGroup(search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(search_jpanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(search_jbutton))
                    .addGroup(search_jpanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_product_id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_product_name_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        search_jpanelLayout.setVerticalGroup(
            search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_jpanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_product_name_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_product_name_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(search_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_product_id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_product_id_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_jbutton)
                .addContainerGap(564, Short.MAX_VALUE))
        );

        option_jtabbedpane.addTab("Search", null, search_jpanel, "");

        product_jpanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        icon_jpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        icon_jLabel.setText("ICON");

        javax.swing.GroupLayout icon_jpanelLayout = new javax.swing.GroupLayout(icon_jpanel);
        icon_jpanel.setLayout(icon_jpanelLayout);
        icon_jpanelLayout.setHorizontalGroup(
            icon_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, icon_jpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon_jLabel)
                .addGap(32, 32, 32))
        );
        icon_jpanelLayout.setVerticalGroup(
            icon_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icon_jpanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(icon_jLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        product_jlabel.setText("Product ID:");

        product_name_jbutton.setText("Product Name: ");

        product_name_textfield.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                product_name_textfieldActionPerformed(evt);
            }
        });

        quantity_jlabel.setText("Qty:");

        quantity_jtextfield.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quantity_jtextfieldActionPerformed(evt);
            }
        });

        price_jlabel.setText("Price:");

        price_jtextfield.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                price_jtextfieldActionPerformed(evt);
            }
        });

        category_jlabel.setText("Category:");

        category_jtextfield.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                category_jtextfieldActionPerformed(evt);
            }
        });

        description_jlabel.setText("Description:");

        description_jtextarea.setColumns(20);
        description_jtextarea.setRows(5);
        description_jscrollpane.setViewportView(description_jtextarea);

        size_label.setText("Size:");

        javax.swing.GroupLayout product_jpanelLayout = new javax.swing.GroupLayout(product_jpanel);
        product_jpanel.setLayout(product_jpanelLayout);
        product_jpanelLayout.setHorizontalGroup(
            product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_jpanelLayout.createSequentialGroup()
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(product_name_jbutton)
                    .addComponent(product_jlabel))
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(product_jpanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(icon_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(product_jpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(product_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(product_id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product_jpanelLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product_jpanelLayout.createSequentialGroup()
                        .addComponent(category_jlabel)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product_jpanelLayout.createSequentialGroup()
                        .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quantity_jlabel)
                            .addComponent(description_jlabel)
                            .addComponent(size_label)
                            .addComponent(price_jlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description_jscrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(product_jpanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(category_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(quantity_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(price_jtextfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(size_jtextfield, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(89, 89, 89))
        );
        product_jpanelLayout.setVerticalGroup(
            product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_jpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(icon_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_jlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product_id_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(product_name_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(product_name_jbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(category_jlabel)
                    .addComponent(category_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(size_label)
                    .addComponent(size_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity_jlabel)
                    .addComponent(quantity_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price_jlabel)
                    .addComponent(price_jtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(product_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description_jscrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description_jlabel))
                .addContainerGap(290, Short.MAX_VALUE))
        );

        option_jtabbedpane.addTab("Product", null, product_jpanel, "");

        button_panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        transaction_jbutton.setText("Transactions");
        transaction_jbutton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                transaction_jbuttonActionPerformed(evt);
            }
        });

        admin_jbutton.setText("Admin");

        menu_jbutton.setText("Menu");
        menu_jbutton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menu_jbuttonActionPerformed(evt);
            }
        });

        add_to_cart_jbutton.setText("Add To Cart");

        javax.swing.GroupLayout button_panelLayout = new javax.swing.GroupLayout(button_panel);
        button_panel.setLayout(button_panelLayout);
        button_panelLayout.setHorizontalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button_panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transaction_jbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu_jbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_to_cart_jbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_jbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        button_panelLayout.setVerticalGroup(
            button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(button_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transaction_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(button_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_to_cart_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        product_jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane4.setViewportView(product_jtable);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        add_product_button.setText("Add Product");
        add_product_button.setToolTipText("");
        add_product_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                add_product_buttonActionPerformed(evt);
            }
        });

        jButton1.setText("Update Product");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        delete_button.setText("Delete Product");
        delete_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(add_product_button)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(delete_button)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_product_button)
                    .addComponent(jButton1)
                    .addComponent(delete_button))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logo_jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(option_jtabbedpane)
                    .addComponent(button_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1486, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logo_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(option_jtabbedpane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_product_id_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_product_id_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_product_id_textfieldActionPerformed

    private void transaction_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaction_jbuttonActionPerformed
        CardLayout card = (CardLayout) this.getParent().getLayout();
        card.show(this.getParent(), "transactionsPanel");
    }//GEN-LAST:event_transaction_jbuttonActionPerformed

    private void menu_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_jbuttonActionPerformed
        CardLayout card = (CardLayout) this.getParent().getLayout();
        card.show(this.getParent(), "launcherMenuPanel");
    }//GEN-LAST:event_menu_jbuttonActionPerformed

    private void search_jbuttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_search_jbuttonActionPerformed
    {//GEN-HEADEREND:event_search_jbuttonActionPerformed
         searchForProducts();       
    }//GEN-LAST:event_search_jbuttonActionPerformed

    private void add_product_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_add_product_buttonActionPerformed
    {//GEN-HEADEREND:event_add_product_buttonActionPerformed
       NewProductDialog dialog = new NewProductDialog(new javax.swing.JFrame(), true);
       dialog.setVisible(true);
       
       Product new_product = dialog.getNewProduct();
       dialog.dispose();
       
       if(new_product != null && new_product.getProductId().length() > 0)
       {
          inventory_accessor.addProduct(new_product);
           threadRecipt();
       }       
       product_list.add(new_product);
    }//GEN-LAST:event_add_product_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_delete_buttonActionPerformed
    {//GEN-HEADEREND:event_delete_buttonActionPerformed
       if(!product_id_textfield.getText().isEmpty())
       {
        
         inventory_accessor.deleteProduct(product_id_textfield.getText());
          product_jtable.clearSelection();
         threadRecipt();

       }
        else
           JOptionPane.showMessageDialog(this,
           "Please select a product",
           "Selection error",
           JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       
        Product update_product = new Product();
        
        update_product.setProductId(product_id_textfield.getText());
        update_product.setCategory(category_jtextfield.getText());
        update_product.setProductName(product_name_textfield.getText());
        update_product.setDescription(description_jtextarea.getText());
        update_product.setPrice(Double.parseDouble(price_jtextfield.getText()));
        update_product.setQuantity(Integer.parseInt(quantity_jtextfield.getText())); 
        update_product.setSize(size_jtextfield.getText());
        
        for (Product record : product_list)
        {
          if (record.getProductId().compareTo(update_product.getProductId()) ==1)
          {
              record = update_product;
          }
        }
        
        int current_selected_row = product_jtable.getSelectedRow();
        product_jtable.setValueAt(product_id_textfield.getText(),current_selected_row,0);
        product_jtable.setValueAt(category_jtextfield.getText(),current_selected_row,1);
        product_jtable.setValueAt(product_name_textfield.getText(),current_selected_row,2);
        product_jtable.setValueAt(description_jtextarea.getText(),current_selected_row,3);
        product_jtable.setValueAt(size_jtextfield.getText(),current_selected_row,4);
        product_jtable.setValueAt(price_jtextfield.getText(),current_selected_row,5);
        product_jtable.setValueAt(quantity_jtextfield.getText(),current_selected_row,6); 
 
        inventory_accessor.updateProduct(update_product);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void category_jtextfieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_category_jtextfieldActionPerformed
    {//GEN-HEADEREND:event_category_jtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category_jtextfieldActionPerformed

    private void price_jtextfieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_price_jtextfieldActionPerformed
    {//GEN-HEADEREND:event_price_jtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price_jtextfieldActionPerformed

    private void quantity_jtextfieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quantity_jtextfieldActionPerformed
    {//GEN-HEADEREND:event_quantity_jtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity_jtextfieldActionPerformed

    private void product_name_textfieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_product_name_textfieldActionPerformed
    {//GEN-HEADEREND:event_product_name_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_name_textfieldActionPerformed

    private void threadRecipt()
    {
       System.out.println("THREAD RECEIPT");
       worker = new InventoryThreadWorker(s,ios,oos,model,product_list);
       worker.execute();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_product_button;
    private javax.swing.JButton add_to_cart_jbutton;
    private javax.swing.JButton admin_jbutton;
    private javax.swing.JPanel button_panel;
    private javax.swing.JLabel category_jlabel;
    private javax.swing.JTextField category_jtextfield;
    private javax.swing.JLabel company_name_label;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel description_jlabel;
    private javax.swing.JScrollPane description_jscrollpane;
    private javax.swing.JTextArea description_jtextarea;
    private javax.swing.JLabel icon_jLabel;
    private javax.swing.JPanel icon_jpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel loco_icon_panel;
    private javax.swing.JLabel logo_jlabel;
    private javax.swing.JPanel logo_jpanel;
    private javax.swing.JButton menu_jbutton;
    private javax.swing.JTabbedPane option_jtabbedpane;
    private javax.swing.JLabel price_jlabel;
    private javax.swing.JTextField price_jtextfield;
    private javax.swing.JTextField product_id_textfield;
    private javax.swing.JLabel product_jlabel;
    private javax.swing.JPanel product_jpanel;
    private javax.swing.JTable product_jtable;
    private javax.swing.JLabel product_name_jbutton;
    private javax.swing.JTextField product_name_textfield;
    private javax.swing.JLabel quantity_jlabel;
    private javax.swing.JTextField quantity_jtextfield;
    private javax.swing.JButton search_jbutton;
    private javax.swing.JPanel search_jpanel;
    private javax.swing.JLabel search_product_id_label;
    private javax.swing.JTextField search_product_id_textfield;
    private javax.swing.JTextField search_product_name_jtextfield;
    private javax.swing.JTextField size_jtextfield;
    private javax.swing.JLabel size_label;
    private javax.swing.JButton transaction_jbutton;
    // End of variables declaration//GEN-END:variables
}
