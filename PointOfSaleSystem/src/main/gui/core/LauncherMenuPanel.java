/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.gui.core;

import java.awt.CardLayout;

/**
 *
 * @author Dakota
 */
public class LauncherMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form LauncherMenuPanel
     */
    public LauncherMenuPanel() {
        initComponents();
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

        inventoryManagementButton = new javax.swing.JButton();
        transactionsButton = new javax.swing.JButton();
        salesMetricsButton = new javax.swing.JButton();
        userManagementButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1238, 678));
        setPreferredSize(new java.awt.Dimension(1878, 1038));

        inventoryManagementButton.setText("InventoryManagement");
        inventoryManagementButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        inventoryManagementButton.setIconTextGap(0);
        inventoryManagementButton.setMaximumSize(new java.awt.Dimension(270, 295));
        inventoryManagementButton.setMinimumSize(new java.awt.Dimension(270, 295));
        inventoryManagementButton.setPreferredSize(new java.awt.Dimension(270, 295));
        inventoryManagementButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        inventoryManagementButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                inventoryManagementButtonActionPerformed(evt);
            }
        });

        transactionsButton.setText("Transactions");
        transactionsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        transactionsButton.setIconTextGap(0);
        transactionsButton.setMaximumSize(new java.awt.Dimension(270, 295));
        transactionsButton.setMinimumSize(new java.awt.Dimension(270, 295));
        transactionsButton.setPreferredSize(new java.awt.Dimension(270, 295));
        transactionsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        transactionsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                transactionsButtonActionPerformed(evt);
            }
        });

        salesMetricsButton.setText("Sales Metrics");
        salesMetricsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salesMetricsButton.setIconTextGap(0);
        salesMetricsButton.setMaximumSize(new java.awt.Dimension(270, 295));
        salesMetricsButton.setMinimumSize(new java.awt.Dimension(270, 295));
        salesMetricsButton.setPreferredSize(new java.awt.Dimension(270, 295));
        salesMetricsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salesMetricsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                salesMetricsButtonActionPerformed(evt);
            }
        });

        userManagementButton.setText("User Management");
        userManagementButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userManagementButton.setIconTextGap(0);
        userManagementButton.setMaximumSize(new java.awt.Dimension(270, 295));
        userManagementButton.setMinimumSize(new java.awt.Dimension(270, 295));
        userManagementButton.setPreferredSize(new java.awt.Dimension(270, 295));
        userManagementButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        userManagementButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userManagementButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.setAlignmentY(0.0F);
        logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButton.setVerifyInputWhenFocusTarget(false);
        logoutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logoutButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventoryManagementButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salesMetricsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(userManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(transactionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transactionsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(inventoryManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                    .addComponent(salesMetricsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryManagementButtonActionPerformed
        CardLayout card = (CardLayout)this.getParent().getLayout();
        card.show(this.getParent(), "inventoryManagementPanel");
    }//GEN-LAST:event_inventoryManagementButtonActionPerformed

    private void transactionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsButtonActionPerformed
        CardLayout card = (CardLayout)this.getParent().getLayout();
        card.show(this.getParent(), "transactionsPanel");
    }//GEN-LAST:event_transactionsButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        CardLayout card = (CardLayout)this.getParent().getLayout();
        card.show(this.getParent(), "loginPanel");
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void salesMetricsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesMetricsButtonActionPerformed
        CardLayout card = (CardLayout)this.getParent().getLayout();
        card.show(this.getParent(), "salesMetricsPanel");
    }//GEN-LAST:event_salesMetricsButtonActionPerformed

    private void userManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userManagementButtonActionPerformed
        CardLayout card = (CardLayout)this.getParent().getLayout();
        card.show(this.getParent(), "userManagementPanel");
    }//GEN-LAST:event_userManagementButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inventoryManagementButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton salesMetricsButton;
    private javax.swing.JButton transactionsButton;
    private javax.swing.JButton userManagementButton;
    // End of variables declaration//GEN-END:variables
}
