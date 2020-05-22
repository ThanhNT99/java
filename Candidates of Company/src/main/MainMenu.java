/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.*;
import java.io.IOException;
import java.util.Scanner;
import functions.*;
import java.util.ArrayList;
import checkInput.*;

/**
 *
 * @author Admin
 */
public class MainMenu {

    Functions f = new Functions();
    CheckInputCandidate input = new CheckInputCandidate();

    public void menu() {
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        System.out.println("1. Experience");
        System.out.println("2.Fresher");
        System.out.println("3.Internship");
        System.out.println("4.Searching");
        System.out.println("5.Exit");
    }

    public int getMenuChoice() throws IOException {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                System.out.print("Please choose an option: ");
                choice = Integer.parseInt(scan.nextLine());         //out of range check
                if (choice < 1 || choice > 5) {
                    System.out.println("Out of range. Please choose 1 to 5 only");
                    System.out.println();
                }
            } catch (NumberFormatException e) {                   //check if input is not number
                System.out.println(e.getMessage() + "is not a number. Please choose 1 to 5 only");
                System.out.println();
            }
        } while (choice < 1 || choice > 5);
        return choice;
    }

    public void case1(ArrayList<Candidates> listC) {
        String s;
        do {
            f.addExperience(listC);
            System.out.println("Do you want to continue?");
            s = input.inputYN();
        } while (s.equalsIgnoreCase("y"));
        System.out.println("List experience:");
        for (Candidates candidates : listC) {
            if (candidates.getType() == 0) {
                Experience e = (Experience) candidates;
                System.out.println(e);
            }
        }
    }

    public void case2(ArrayList<Candidates> listC) {
        String s;
        do {
            f.addFresher(listC);
            System.out.println("Do you want to continue?");
            s = input.inputYN();
        } while (s.equalsIgnoreCase("y"));
        System.out.println("List fresher:");
        for (Candidates candidates : listC) {
            if (candidates.getType() == 1) {
                Fresher f = (Fresher) candidates;
                System.out.println(f);
            }
        }
    }

    public void case3(ArrayList<Candidates> listC) {
        String s;
        do {
            f.addIntern(listC);
            System.out.println("Do you want to continue?");
            s = input.inputYN();
        } while (s.equalsIgnoreCase("y"));
        System.out.println("List intern");
        for (Candidates candidates : listC) {
            if (candidates.getType() == 2) {
                Intern i = (Intern) candidates;
                System.out.println(i);
            }
    }
    }
    public void case4(ArrayList<Candidates> list) {
        System.out.println("Input Candidate name: ");
        String name = input.inputName();
        System.out.print("Input Type of Candidates (0-Experience, 1-Fresher, 2-Intern): ");
        int type = input.inputType();
        f.searchByNameAndType(list, name, type);
    }
}
