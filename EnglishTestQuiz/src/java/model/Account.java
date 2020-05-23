/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Account {
    private String username;
    private String password;
    private int roleid;
    private ArrayList<String> servletpath = new ArrayList<>();
    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, int roleid, String servletpath) {
        this.username = username;
        this.password = password;
        this.roleid = roleid;
        this.servletpath.add(servletpath);
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public ArrayList<String> getServletpath() {
        return servletpath;
    }

    public void setServletpath(String servletpath) {
        this.servletpath.add(servletpath);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        //return "Account{" + "username=" + username + ", password=" + password + ", roleid=" + roleid + ", servletpath=" + servletpath + '}';
        String result = "username=" + username + ", password=" + password + ", roleid=" + roleid + " ";
        
        for (String string : servletpath) {
            result+=string+" ";
        }
        
        return result;
    }

   
    

    
    
    
}
