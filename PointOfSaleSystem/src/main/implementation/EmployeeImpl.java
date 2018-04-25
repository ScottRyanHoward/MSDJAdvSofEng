/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import main.interfaces.DatabaseConnection_I;
import main.structures.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import main.structures.Employee;

/**
 *
 * @author Matt HP
 */
public class EmployeeImpl implements main.interfaces.Employee_I, 
                                     main.interfaces.Login_I
{
    private final String secret_passcode = "Spring2018SEClassSHELVS";
    
    ObjectOutputStream oos = null;
    ObjectInputStream ios = null;


    public EmployeeImpl(ObjectInputStream input_stream, ObjectOutputStream output_stream)
    {
        this.ios = input_stream;
        this.oos = output_stream;
    }
    
    private void executeSql(String query)
    {
        try
        {
            System.out.println("QUERY = " + query);
            oos.writeObject(query);
            oos.flush();
        }
        catch (IOException e)
        {
            System.out.println (e);
        }
    }

    @Override
    public void getEmployee(String id)
    {
       String query = "SELECT * FROM Employee "  + 
               "WHERE employee_id = '" + id + "'";
       executeSql(query);
    }

    @Override
    public void getAllEmployees()
    {         
       String query = "SELECT * FROM Employee ";
       executeSql(query);
    }
    
    @Override
    public void addEmployee(Employee new_employee)
    {
       String query = "INSERT INTO Employee (employee_id, first_name, last_name,address,ssn,account_password,wage,hours,is_admin) " +
       "VALUES ('" + new_employee.getEmployeeId() + "','" + new_employee.getFirstName() + "' ,'" +
        new_employee.getLastName() + "' , '" + new_employee.getAddress() + "'," + 
        new_employee.getSsn() + 
        ",AES_ENCRYPT('" + new_employee.getAccountPassword() + "', UNHEX(SHA2('" + secret_passcode + "',512)))," + //Password is encrypted using the hashed passcode as the key
        new_employee.getWage() + " , " + new_employee.getHours() + "," + 
        new_employee.getIsAdmin() + ")";
       
        executeSql(query);
    }

    @Override
    public void updateEmployee(Employee update_employee)
    {        
        String query = "UPDATE Employee "  + "SET " +
        "employee_id = '" + update_employee.getEmployeeId()+ "'," +
        "first_name = '" + update_employee.getFirstName()+ "'," +
        "last_name = '" + update_employee.getLastName() + "'," +
        "address = '" + update_employee.getAddress() + "'," +
        "ssn = " + update_employee.getSsn()+ "," +
        "account_password = " +  "AES_ENCRYPT('" + update_employee.getAccountPassword() + "', UNHEX(SHA2('" + secret_passcode + "',512)))," + //Password is encrypted using the hashed passcode as the key
        "wage = " +  update_employee.getWage() + "," +
        "hours = " +  update_employee.getHours() + "," +
        "is_admin = " +  update_employee.getIsAdmin() + 
        " WHERE employee_id = '" + update_employee.getEmployeeId() + "'";
        executeSql(query);
    }

    @Override
    public void deleteEmployee(String id)
    {
      String query = "DELETE FROM Employee " +
        "WHERE employee_id = '" + id + "'";                
      executeSql(query);
        
    }
    
    @Override
    public void searchEmployees(String search_field, String search_value)
    {
       String query = "SELECT * FROM Employee WHERE " + search_field + " LIKE '%" + search_value + "%'";
       executeSql(query);
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public void checkLogin(String employee_id, String password)
    {
          String query = "SELECT * FROM Employee "  + "WHERE employee_id = '" + employee_id + "' " +
          "AND AES_DECRYPT(account_password, UNHEX(SHA2('" + secret_passcode + "',512))) = '" + password + "'";
          executeSql(query);               
    }
    
}
