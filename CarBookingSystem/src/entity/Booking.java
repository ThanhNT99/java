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
public class Booking {
    private int ID;
    private String pickupCity;
    private String pickupLocation;
    private String dropLocation;
    private int customerID;
    private int driverID;

    public Booking() {
    }

    public Booking(int ID, String pickupCity, String pickupLocation, String dropLocation, int customerID, int driverID) {
        this.ID = ID;
        this.pickupCity = pickupCity;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.customerID = customerID;
        this.driverID = driverID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
    
    
    
    public String showBooking(){
        return "Booking{" + "ID=" + ID + ", pickupCity=" + pickupCity + ", pickupLocation=" + pickupLocation + ", dropLocation=" + dropLocation + ", customerID=" + customerID + ", driverID=" + driverID + '}';
    }
    
}
