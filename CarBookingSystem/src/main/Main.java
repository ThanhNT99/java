package main;

import model.MainMenu;
import model.ValidateInput;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ch;
        MainMenu m = new MainMenu();
        ValidateInput v = new ValidateInput();
        do {            
            new Main().display();
            ch = v.inputPositiveIntFromTo(1, 4);
            switch(ch){
                case 1: 
                    m.addCarBooking();
                    break;
                case 2: 
                    m.displayBookingDetail();
                    break;
                case 3:
                    m.completeTrip();
                case 4: break;
            }
        } while (ch!=4);
    }
    public void display(){
        System.out.println("\n1. Create a car booking"
                + "\n2. Display the booking"
                + "\n3. Complete a trip"
                + "\n4. Exit"
                + "\nPlease choose an option:"); 
    }
}
