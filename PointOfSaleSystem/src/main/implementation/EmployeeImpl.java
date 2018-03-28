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

/**
 *
 * @author Matt HP
 */
public class EmployeeImpl implements main.interfaces.Employee_I, 
                                     main.interfaces.Login_I
{
    private Connection connection;
    private DatabaseConnection_I db_connection;
    public EmployeeImpl(DatabaseConnection_I input_db_connection)
    {
      db_connection = input_db_connection;
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
            String command = "SELECT * FROM employee ";
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
                    employee.setIsAdmin(Boolean.parseBoolean(result.getString("isAdmin")));

                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("getProduct " + e);
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
                    employee.setIsAdmin(Boolean.parseBoolean(result.getString("isAdmin")));
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
       "VALUES (" + new_employee.getEmployeeId() + "," + new_employee.getFirstName() + " ," +
        new_employee.getLastName() + " , " + new_employee.getAddress() + "," + 
        new_employee.getSsn() + "," + new_employee.getAccountPassword() + 
        new_employee.getWage() + " , " + new_employee.getHours() + "," + 
        new_employee.getIsAdmin() + ")";
       
        executeSqlStatement(query);
    }

    @Override
    public void updateEmployee(Employee update_employee)
    {        
        String query = "UPDATE employee "  + "SET " +
        "employee_id = " + update_employee.getEmployeeId()+ "," +
        "first_name = " + update_employee.getFirstName()+ "," +
        "last_name = " + update_employee.getLastName() + "," +
        "address = " + update_employee.getAddress() + "," +
        "ssn = " + update_employee.getSsn()+ "," +
        "account_password = " +  update_employee.getAccountPassword() + 
        "wage = " +  Double.toString(update_employee.getWage()) + 
        "hours = " +  update_employee.getHours() + 
        "is_admin = " +  Boolean.toString(update_employee.getIsAdmin()) + 
        "WHERE employee_id = " + update_employee;
        executeSqlStatement(query);
    }

    @Override
    public void deleteEmployee(String id)
    {
         String query = "DELETE FROM employee " +
        "WHERE employee_id = " + id;                
      
        executeSqlStatement(query);
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
          String command = "SELECT * FROM employee where employee_id = '" +employee_id + 
                  "'AND account_password = '" + password + "'";
                  
          ResultSet result = statement.executeQuery(command);
            
            if (null != result)
            {
               return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println("getProduct " + e);
        } 
       return false;
    }
    
}
