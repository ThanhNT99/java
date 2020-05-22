/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.BookingDAO;
import entity.Booking;
import entity.Driver;
import java.util.ArrayList;
import model.ValidateInput;

/**
 *
 * @author dell
 */
public class MainMenu {
    ValidateInput v = new ValidateInput();
    BookingDAO bdao = new BookingDAO();
    public void addCarBooking(){
        Driver driverChoosen = bdao.getFreeDriverWithHighestRate();
        if (driverChoosen==null){
            System.out.println("Sorry! All drivers are busy");
        }
        else
        {
            System.out.println("Enter pickup city:");
            String pickup_city = v.process(v.inputNotEmptyString());
            System.out.println("Enter location A:");
            String locationA = v.process(v.inputNotEmptyString());
            System.out.println("Enter location B:");
            String locationB = v.process(v.inputNotEmptyString());
            System.out.println("Enter customer ID:");
            int customerID;
            do {
                customerID = v.inputPositiveInt();
                if (bdao.getCustomerByID(customerID) == null) {
                    System.err.println("CustomerID doesn't exist! Please re-enter.");
                    continue;
                } else if (!bdao.isFreeCustomer(customerID)) {
                    System.err.println("CustomerID is not available to book car! Please re-enter."); //customer is on a trip
                } else {
                    break;
                }
            } while (true);
            
            System.out.println("Automatically choosing your driver...");

            bdao.addBookingDAO(pickup_city, locationA, locationB, customerID, driverChoosen.getID());
            System.out.println("Hi " + bdao.getCustomerByID(customerID).getName()
                    + "!\nEnjoy your trip with driver " + driverChoosen.getName()
                    + " in " + pickup_city + " from " + locationA + " to " + locationB);
        }   
    }
    
    public void displayBookingDetail(){
        ArrayList<Booking> arrBooking = bdao.getAllBooking();
        if (arrBooking.isEmpty()){
            System.err.println("No booking!");
        }
        else{
            System.out.printf("%-15s%-20s%-20s%-20s%-15s%-15s", "Booking ID", "Pickup city", "Pickup location", "Drop location", "Customer ID", "Driver ID");
            for (Booking b : arrBooking) {
                System.out.println("");
                System.out.printf("%-15s%-20s%-20s%-20s%-15s%-15s", b.getID(), b.getPickupCity(), b.getPickupLocation(), b.getDropLocation(), b.getCustomerID(), b.getDriverID());
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        new MainMenu().displayBookingDetail();
    }

    public void completeTrip() {
        if (bdao.getAllBooking().isEmpty()){
            System.err.println("No booking!");
        }
        else{
            System.out.println("Enter booking ID:");
            int bookingID;
            do {
                bookingID = v.inputPositiveInt();
                if (bdao.getBookingByID(bookingID) != null) {
                    break;
                } else {
                    System.err.println("Booking ID does not exist! Please re-enter");
                }
            } while (true);
            bdao.deleteBookingByID(bookingID);
        }
    }
}
