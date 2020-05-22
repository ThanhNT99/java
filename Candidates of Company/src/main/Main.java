package main;

import entity.*;
import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Candidates> listCandidates = new ArrayList<>();
        listCandidates.add(new Experience("1", "Thanh", "Thanh", 1999, "Ha Noi", "0384139260", "thanh@gmail.com", 0, 1, "SE"));
        listCandidates.add(new Fresher("2", "Hue", "Dinh", 1999, "Ha Noi", "0329685201", "hue@gmail.com", 1, 2019, "Good", "FPT"));
        listCandidates.add(new Intern("3", "Ha", "Nhat", 1999, "Ha Noi", "0936391776", "ha@gmail.com", 2, "SE", 3, "FPT"));
        MainMenu mainMenu = new MainMenu();
        process:
        do {
            mainMenu.menu();
            int choice = mainMenu.getMenuChoice();
            switch (choice){
                case 1: mainMenu.case1(listCandidates);  break;
                case 2: mainMenu.case2(listCandidates); break;
                case 3: mainMenu.case3(listCandidates); break;
                case 4: mainMenu.case4(listCandidates); break;
                case 5: break process;
            }
        } while (true);
    }

}
