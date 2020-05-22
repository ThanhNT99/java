/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dell
 */
public class Driver {
    private int ID;
    private String name;
    private String phoneNo;
    private String address;
    private double rate;

    public Driver() {
    }

    public Driver(int ID, String name, String phoneNo, String address, double rate) {
        this.ID = ID;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.rate = rate;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Driver{" + "ID=" + ID + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + ", rate=" + rate + '}';
    }
    
    
    public int getFreeDriver(){
        return -1;
    }
}
