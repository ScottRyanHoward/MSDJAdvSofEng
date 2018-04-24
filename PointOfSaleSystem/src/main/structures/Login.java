/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.structures;

import java.io.Serializable;

public class Login implements Serializable
{
    private String username;
    private boolean successful;
    
    public Login()
    {
      username = "";
      successful = false;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String new_username)
    {
        this.username = new_username;
    }

    public Boolean getSuccessful()
    {
        return successful;
    }

    public void setSuccessful(Boolean new_successful)
    {
        this.successful = new_successful;
    }
}
