/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.implementation;

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
    private Connection connection;
    private DatabaseConnection_I db_connection;
    private final String secret_passcode = "Spring2018SEClassSHELVS";
    
    public EmployeeImpl()
    {
      db_connection = new DatabaseConnectionImpl();
    }
    
    private void executeSqlStatement(String sql_statement)
    {
        try
        {
        connection = db_connection.connectToDatabase();
        Statement statement = connection.createStatement();
        statement.execute(sql_statement);
        }
        catch (SQLException e)
        {
            System.out.println("updateProduct " + e);
        }
    }

    @Override
    public Employee getEmployee(String id)
    {
        Employee employee = new Employee();
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM employee "  + "WHERE employee_id = '" + id + "'";
            ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
                while (result.next())
                {
                    employee.setEmployeeId(result.getString("employee_id"));
                    employee.setFirstName(result.getString("first_name"));
                    employee.setLastName(result.getString("last_name"));
                    employee.setAddress(result.getString("address"));
                    employee.setHours(Double.parseDouble(result.getString("hours")));
                    employee.setWage(Double.parseDouble(result.getString("wage")));
                    employee.setSsn(Integer.parseInt(result.getString("ssn")));
                    employee.setAccountPassword(result.getString("account_password"));
                    employee.setIsAdmin(result.getBoolean("is_admin"));
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getEmployee " + e);
        } 
        return employee;
    }

    @Override
    public ArrayList<Employee> getAllEmployees()
    {         
        ArrayList<Employee> employee_list = new ArrayList();
        
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM employee ";
            ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
                while (result.next())
                {
                    Employee employee = new Employee();
                    employee.setEmployeeId(result.getString("employee_id"));
                    employee.setFirstName(result.getString("first_name"));
                    employee.setLastName(result.getString("last_name"));
                    employee.setAddress(result.getString("address"));
                    employee.setHours(Double.parseDouble(result.getString("hours")));
                    employee.setWage(Double.parseDouble(result.getString("wage")));
                    employee.setSsn(Integer.parseInt(result.getString("ssn")));
                    employee.setAccountPassword(result.getString("account_password"));
                    employee.setIsAdmin(result.getBoolean("is_admin"));
                    employee_list.add(employee);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getProduct " + e);
        } 
        return employee_list;
    }
    
    @Override
    public void addEmployee(Employee new_employee)
    {
       String query = "INSERT INTO employee (employee_id, first_name, last_name,address,ssn,account_password,wage,hours,is_admin) " +
       "VALUES ('" + new_employee.getEmployeeId() + "','" + new_employee.getFirstName() + "' ,'" +
        new_employee.getLastName() + "' , '" + new_employee.getAddress() + "'," + 
        new_employee.getSsn() + 
        ",AES_ENCRYPT('" + new_employee.getAccountPassword() + "', UNHEX(SHA2('" + secret_passcode + "',512)))," + //Password is encrypted using the hashed passcode as the key
        new_employee.getWage() + " , " + new_employee.getHours() + "," + 
        new_employee.getIsAdmin() + ")";
       
        executeSqlStatement(query);
    }

    @Override
    public void updateEmployee(Employee update_employee)
    {        
        String query = "UPDATE employee "  + "SET " +
        "employee_id = '" + update_employee.getEmployeeId()+ "'," +
        "first_name = '" + update_employee.getFirstName()+ "'," +
        "last_name = '" + update_employee.getLastName() + "'," +
        "address = '" + update_employee.getAddress() + "'," +
        "ssn = " + update_employee.getSsn()+ "," +
        "account_password = '" +  update_employee.getAccountPassword() + "'," +
        "wage = " +  update_employee.getWage() + "," +
        "hours = " +  update_employee.getHours() + "," +
        "is_admin = " +  update_employee.getIsAdmin() + 
        " WHERE employee_id = '" + update_employee.getEmployeeId() + "'";
        executeSqlStatement(query);
    }

    @Override
    public void deleteEmployee(String id)
    {
         String query = "DELETE FROM employee " +
        "WHERE employee_id = '" + id + "'";                
      
        executeSqlStatement(query);
    }
    
    public ArrayList<Employee> searchEmployees(String search_field, String search_value)
    {
        ArrayList<Employee> employee_list = new ArrayList();
        
        try
        {
            connection = db_connection.connectToDatabase();
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM employee WHERE " + search_field + " LIKE '" + search_value + "'";
            ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
                while (result.next())
                {
                    Employee employee = new Employee();
                    employee.setEmployeeId(result.getString("employee_id"));
                    employee.setFirstName(result.getString("first_name"));
                    employee.setLastName(result.getString("last_name"));
                    employee.setAddress(result.getString("address"));
                    employee.setHours(Double.parseDouble(result.getString("hours")));
                    employee.setWage(Double.parseDouble(result.getString("wage")));
                    employee.setSsn(Integer.parseInt(result.getString("ssn")));
                    employee.setAccountPassword(result.getString("account_password"));
                    employee.setIsAdmin(result.getBoolean("is_admin"));
                    employee_list.add(employee);
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getProduct " + e);
        } 
        return employee_list;
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean checkLogin(String employee_id, String password)
    {
        try
        {
          connection = db_connection.connectToDatabase();
          Statement statement = connection.createStatement();
          String command = "SELECT * FROM employee "  + "WHERE employee_id = '" + employee_id + "' " +
          "AND AES_DECRYPT(account_password, UNHEX(SHA2('" + secret_passcode + "',512))) = '" + password + "'";
                  
          ResultSet result = statement.executeQuery(command);
            
            if (result.next()) //A record has been found
            {
               return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Check Login " + e);
        } 
       return false;
    }
    
}
