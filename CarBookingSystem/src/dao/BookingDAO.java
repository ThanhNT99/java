/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DBConnection.getConnection;
import entity.Booking;
import entity.Customer;
import entity.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class BookingDAO {
    private static String DB_URL = "jdbc:mysql://localhost:3306/car_booking_system?useSSL=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";
    private DBConnection dbcon = new DBConnection();
    
    public boolean addBookingDAO(String pickupCity, String locationA, String locationB,  int customerID, int driverID){
        try {
            Connection conn = dbcon.getConnection(DB_URL, USER_NAME, PASSWORD);
        
            String query = " insert into booking (pickup_city, pickup_location, drop_location, customer_id, driver_id)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, pickupCity);
            preparedStmt.setString(2, locationA);
            preparedStmt.setString(3, locationB);
            preparedStmt.setInt(4, customerID);
            preparedStmt.setInt(5, driverID);

            // execute the preparedstatement
            preparedStmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Booking> getAllBooking(){
        ArrayList<Booking> arrBooking = new ArrayList<>();
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("select * from booking");
            // show data
            while (rs.next()) {
                Booking b = new Booking(rs.getInt("booking_id"), 
                                        rs.getString("pickup_city"), 
                                        rs.getString("pickup_location"), 
                                        rs.getString("drop_location"), 
                                        rs.getInt("customer_id"), 
                                        rs.getInt("driver_id"));
                arrBooking.add(b);
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return arrBooking;
    }
    
    public Driver getFreeDriverWithHighestRate(){
        ArrayList<Driver> arrFreeDrivers = new ArrayList<>();
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("SELECT *\n"
                    + "  FROM driver\n"
                    + " WHERE NOT EXISTS(SELECT NULL\n"
                    + "                    FROM booking\n"
                    + "                   WHERE booking.driver_id = driver.id)"
                    + "\nORDER BY driver.rate DESC"
                    + "\nLIMIT 1");
            // show data
            while (rs.next()) {
                Driver d = new Driver(rs.getInt("id"),
                                      rs.getString("name"), 
                                      rs.getString("phone_no"), 
                                      rs.getString("address"), 
                                      rs.getDouble("rate"));
                return d;
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null; //no free driver
    }
    
    
    
    public Driver getDriverByID(int id){
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String query = "SELECT *\n"
                    + "  FROM driver\n"
                    + " WHERE id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            // show data
            if (rs.next()) {
                Driver d = new Driver(rs.getInt("id"),
                                      rs.getString("name"), 
                                      rs.getString("phone_no"), 
                                      rs.getString("address"), 
                                      rs.getDouble("rate"));
                return d;
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null; //not exists driver with this id
    }
    
    public Booking getBookingByID(int id){
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String query = "SELECT *\n"
                    + "  FROM booking\n"
                    + " WHERE booking_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            // show data
            if (rs.next()) {
                Booking b = new Booking(rs.getInt("booking_id"),
                                      rs.getString("pickup_city"), 
                                      rs.getString("pickup_location"), 
                                      rs.getString("drop_location"), 
                                      rs.getInt("customer_id"),
                                      rs.getInt("driver_id"));
                return b;
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null; //not exists booking with this id
    }
    public Customer getCustomerByID(int id){
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String query = "SELECT *\n"
                    + "  FROM customer\n"
                    + " WHERE id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            // show data
            if (rs.next()) {
                Customer c = new Customer(rs.getInt("id"),
                                      rs.getString("name"), 
                                      rs.getString("email"), 
                                      rs.getString("phone_no"));
                return c;
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null; //not exists driver with this idk
    }
    
    public boolean isFreeCustomer(int id){
        try {
            // connnect to database 'car_booking_system'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
            String query = "SELECT *\n"
                    + "  FROM booking\n"
                    + " WHERE customer_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            // show data
            if (rs.next()) {
                return false; //is not free
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true; //is free
    }
    

    public boolean deleteBookingByID(int bookingID) {
        try {
            Connection conn = dbcon.getConnection(DB_URL, USER_NAME, PASSWORD);
        
            String query = "DELETE FROM booking WHERE (booking_id = ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, bookingID);
            // execute the preparedstatement
            return preparedStmt.executeUpdate()>0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
   
    public static void main(String[] args) {
       BookingDAO bookingDAO = new BookingDAO();
       System.out.println(bookingDAO.getFreeDriverWithHighestRate());
       System.out.println(bookingDAO.deleteBookingByID(4));
    }
}
