package main;

import entity.Fruit;
import entity.Order;
import java.io.IOException;
import functions.*;
import java.util.ArrayList;
import java.util.Hashtable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        MainMenu m = new MainMenu();
        ArrayList<Fruit> listFruit = new ArrayList<>();
        Functions f = new Functions();
        ArrayList<Order> listOrd = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        listFruit.add(new Fruit("1", "apple", 10, 10, "Ha Noi"));
        listFruit.add(new Fruit("2", "orange", 9, 10, "Ha Noi"));
        listFruit.add(new Fruit("3", "tomato", 8, 10, "Ha Noi"));
        process:
        do {
            m.menu();
            int choice = m.getChoice(1,4);
            switch (choice){
                case 1: f.addFruit(listFruit);  break;
                case 2: f.viewOrders(ht); break;
                case 3: f.shopping(ht, listFruit); break;
                case 4: break process;
            }
        } while (true);
    }
    
}
