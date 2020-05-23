/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Fruit;
import entity.Order;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import functions.Functions;
import checkinput.CheckInput;
/**
 *
 * @author Admin
 */
public class MainMenu {

    public void menu() {
        System.out.println("FRUIT SHOP SYSTEM");
        System.out.println("1. Create fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.println("Please choose 1 to create product, 2 to view order, 3 for shopping, 4 to Exit progam");
    }

    public int getChoice(int begin, int end) throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                System.out.print("Please choose an option: ");
                choice = Integer.parseInt(scan.nextLine());         //out of range check
                if (choice < begin || choice > end) {
                    System.out.println("Out of range. Please choose "+ begin +" to " + end + " only");
                    System.out.println();
                }
            } catch (NumberFormatException e) {                   //check if input is not number
                System.out.println(e.getMessage() + "is not a number. Please choose "+ begin +" to " + end + " only");
                System.out.println();
            }
        } while (choice < begin || choice >end);
        return choice;
    }

}
