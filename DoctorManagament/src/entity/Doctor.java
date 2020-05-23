/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Doctor {
    /*
     ID is a positive integer number, and automatically increase when it’s added. It starts from 1 and will be the last doctor’s ID in the list plus 1.  
     Name is a string which is not longer than 50 characters. 
     DateOfBirth is a string which conforms “dd/MM/yyyy” format. 
     Specialization is a string which is not longer than 255 characters. 
     Availability is integer number indicating 4 states of a doctor: 0 for in vacation, 1 for available, 2 for busy in emergency case, 3 for in diagnosing case. 
     Email is a string conforming email format 
     Mobile is a string of number conforming (000)-000-0000 format.
    */
    
    private int ID;
    private String name;
    private Date DOB;
    private String spec;
    private int availability;
    private String email;
    private String mobile;

    public Doctor() {
    }

    public Doctor(int ID, String name, Date DOB, String spec, int availability, String email, String mobile) {
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.spec = spec;
        this.availability = availability;
        this.email = email;
        this.mobile = mobile;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Doctor{" + "ID=" + ID + ", name=" + name + ", DOB=" + dateFormat.format(DOB)  + ", spec=" + spec + ", availability=" + availability + ", email=" + email + ", mobile=" + mobile + '}';
    }
    
    
}
