/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import Interfaces.DatabaseConnection_I;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matt HP
 */
public class DatabaseConnectionImpl implements DatabaseConnection_I
{
        private Connection con;

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public Connection connectToDatabase() throws SQLException
    {
            
        try {
             Class.forName("com.mysql.jdbc.Driver");
            }
            catch(ClassNotFoundException ex) {
                System.err.println("Unable to load MySQL Driver");
            }
        try
        {
                       String url = "jdbc:mysql://localhost:3306/pos_system";
                       
          con = DriverManager.getConnection(url,"root","MSDJ");
          
             System.out.println("Connected!"); 
             return con;
        }
           
            catch(Exception e) {
               System.err.println("Unable to load MySQL Driver");
                              System.err.println(e);

            } 
 

        return null;
    }
}
