/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Matt HP
 */
public interface DatabaseConnection_I
{
    public Connection connectToDatabase() throws SQLException;
}

