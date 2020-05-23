/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Order {
    private String id;
    private String fruitName;
    private int quantity;
    private double price;
    private double amount;

    public Order() {
    }

    public Order(String id, String fruitName, int quantity, double price) {
        this.id = id;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
        this.amount = quantity*price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        System.out.printf("%-20s%-20d%-20s%.3f%s", fruitName, quantity, price + "$", amount, "$");
        return "";
    }
   
    
}
