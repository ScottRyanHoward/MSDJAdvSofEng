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
import main.interfaces.Login_I;
import javax.swing.JOptionPane;
import main.structures.Login;
import main.threadworkers.LoginWorker;

/**
 *
 * @author Dakota
 */
public class LoginPanel extends javax.swing.JPanel {

    Login_I login_handler;
    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;
    private Socket socket;
    LoginWorker worker;
    Login login;
    
    /**
     * Creates new form LoginPanel
     */
    public LoginPanel(Login_I login_handler, Socket s, 
            ObjectOutputStream new_oos , ObjectInputStream new_ios) 
    {
        initComponents();
        this.login_handler = login_handler;
        this.socket = s;
        this.oos = new_oos;
        this.ios = new_ios;
        
       // CardLayout card = (CardLayout)this.getParent().getLayout();
       // card.show(this.getParent(), "launcherMenuPanel");
                
              
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productLogoPanel = new javax.swing.JPanel();
        softwareLogoLable = new javax.swing.JLabel();
        companyLogoPanel = new javax.swing.JPanel();
        companyLogoLabel = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userIdField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        authorInformationPanel = new javax.swing.JPanel();
        authorInformationLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1878, 1038));

        productLogoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        softwareLogoLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        softwareLogoLable.setText("SOFTWARE LOGO");

        javax.swing.GroupLayout productLogoPanelLayout = new javax.swing.GroupLayout(productLogoPanel);
        productLogoPanel.setLayout(productLogoPanelLayout);
        productLogoPanelLayout.setHorizontalGroup(
            productLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productLogoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(softwareLogoLable, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        productLogoPanelLayout.setVerticalGroup(
            productLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productLogoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(softwareLogoLable, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        companyLogoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        companyLogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        companyLogoLabel.setText("COMPANY LOGO");

        javax.swing.GroupLayout companyLogoPanelLayout = new javax.swing.GroupLayout(companyLogoPanel);
        companyLogoPanel.setLayout(companyLogoPanelLayout);
        companyLogoPanelLayout.setHorizontalGroup(
            companyLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyLogoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companyLogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        companyLogoPanelLayout.setVerticalGroup(
            companyLogoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(companyLogoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(companyLogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addContainerGap())
        );

        userIdLabel.setText("User ID");

        passwordLabel.setText("Password");

        loginButton.setText("Log In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        authorInformationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorInformationLabel.setText("Created by MSDJ2");

        javax.swing.GroupLayout authorInformationPanelLayout = new javax.swing.GroupLayout(authorInformationPanel);
        authorInformationPanel.setLayout(authorInformationPanelLayout);
        authorInformationPanelLayout.setHorizontalGroup(
            authorInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, authorInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        authorInformationPanelLayout.setVerticalGroup(
            authorInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, authorInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorInformationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(759, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userIdLabel)
                            .addComponent(passwordLabel))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(userIdField)))
                    .addComponent(authorInformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(759, 759, 759))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productLogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyLogoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(839, 839, 839))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(companyLogoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(authorInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        String id = userIdField.getText();
        String password = String.valueOf(passwordField.getPassword());
        
        login_handler.checkLogin(id, password);
        threadRecipt();
        
     /*   {
            CardLayout card = (CardLayout)this.getParent().getLayout();
            card.show(this.getParent(), "launcherMenuPanel");
            //Clear so when user logs out, there isn't leftover information
            userIdField.setText(null);
            passwordField.setText(null);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid ID and Password combination", "ERROR", JOptionPane.ERROR_MESSAGE); 
        }*/
    }//GEN-LAST:event_loginButtonActionPerformed

    private void threadRecipt()
    {
        System.out.println("THREAD RECEIPT");
        worker = new LoginWorker(socket, ios, oos, login);
        worker.execute();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorInformationLabel;
    private javax.swing.JPanel authorInformationPanel;
    private javax.swing.JLabel companyLogoLabel;
    private javax.swing.JPanel companyLogoPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel productLogoPanel;
    private javax.swing.JLabel softwareLogoLable;
    private javax.swing.JTextField userIdField;
    private javax.swing.JLabel userIdLabel;
    // End of variables declaration//GEN-END:variables
}
