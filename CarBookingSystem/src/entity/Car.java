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
public class Car {
    private int registrationNO;
    private String make;
    private String model;
    private int occupancy;
    private int driverID;

    public Car() {
    }

    public Car(int registrationNO, String make, String model, int occupancy, int driverID) {
        this.registrationNO = registrationNO;
        this.make = make;
        this.model = model;
        this.occupancy = occupancy;
        this.driverID = driverID;
    }

    public int getRegistrationNO() {
        return registrationNO;
    }

    public void setRegistrationNO(int registrationNO) {
        this.registrationNO = registrationNO;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    @Override
    public String toString() {
        return "Car{" + "registrationNO=" + registrationNO + ", make=" + make + ", model=" + model + ", occupancy=" + occupancy + ", driverID=" + driverID + '}';
    }
    
}
