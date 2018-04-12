/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.interfaces;

import main.structures.Employee;
import java.util.ArrayList;
/**
 *
 * @author Matt HP
 */
public interface Employee_I
{
    Employee getEmployee(String id);
    void addEmployee(Employee new_employee);
    void updateEmployee(Employee update_employee);
    void deleteEmployee(String id);
    ArrayList<Employee> getAllEmployees();
    ArrayList<Employee> searchEmployees(String search_field, String search_value) ;   
}
