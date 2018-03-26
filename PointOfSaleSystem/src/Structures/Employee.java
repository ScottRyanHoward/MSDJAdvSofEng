/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author Matt HP
 */
public class Employee
{

    private String employee_id;
    private String first_name;
    private String last_name;
    private String address;
    private int ssn;
    private String account_password;
    private double wage;
    private double hours;
    private boolean is_admin;

    public Employee()
    {
        employee_id = "";
        first_name = "";
        last_name = "";
        address = "";
        ssn = 0;
        account_password = "";
        wage = 0.00;
        hours = 0.0;
    }

    /**
     * @return the employee_id
     */
    public String getEmployeeId()
    {
        return employee_id;
    }

    /**
     * @param employee_id the employee_id to set
     */
    public void setEmployeeId(String employee_id)
    {
        this.employee_id = employee_id;
    }

    /**
     * @return the first_name
     */
    public String getFirstName()
    {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

        /**
     * @return the last_name
     */
    public String getLastName()
    {
        return last_name;
    }

    
    /**
     * @param last_name the last_name to set
     */
    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the ssn
     */
    public int getSsn()
    {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(int ssn)
    {
        this.ssn = ssn;
    }

    /**
     * @return the account_password
     */
    public String getAccountPassword()
    {
        return account_password;
    }

    /**
     * @param account_password the account_password to set
     */
    public void setAccountPassword(String account_password)
    {
        this.account_password = account_password;
    }

    /**
     * @return the wage
     */
    public double getWage()
    {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(double wage)
    {
        this.wage = wage;
    }

    /**
     * @return the hours
     */
    public double getHours()
    {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(double hours)
    {
        this.hours = hours;
    }
        /**
     * @return the is_admin
     */
    public boolean getIsAdmin()
    {
        return is_admin;
    }

    /**
     * @param is_admin the is_admin to set
     */
    public void setIsAdmin(boolean is_admin)
    {
        this.is_admin = is_admin;
    }
}
