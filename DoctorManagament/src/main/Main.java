package main;

import entity.Doctor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import model.DoctorDAO;
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
        ArrayList<Doctor> a = new ArrayList<>();
        a.add(new Doctor(1, "Nguyen Thanh", new Date("1999/12/11"), "SE", 0, "Thanh@gmail.com", "(000)-000-0000"));
        a.add(new Doctor(2, "Le Manh Cuong", new Date("1999/08/07"), "BA", 0, "Cuong@gmail.com", "(000)-010-0000"));
        for (Doctor doctor : a) {
            System.out.println(doctor);
        }
        ValidateInput input = new ValidateInput();
        DoctorDAO dao = new DoctorDAO();
        boolean exit = false;
        menu();
        do {
            int ch = input.inputPositiveInt();
            switch (ch) {
                case 1:
                    dao.add(a);
                    break;
                case 2:
                    System.out.println("Input Docter ID you want to update:");
                    int uID = input.inputPositiveInt();
                    dao.update(a, uID);
                    break;
                case 3:
                    System.out.println("Input Docter ID you want to delete");
                    int dID = input.inputPositiveInt();
                    dao.delete(a, dID);
                    break;
                case 4:
                    System.out.println("Which field do you want to search by? 1. ID 2. Name");
                    boolean con = false;
                    do {
                        int choice = input.inputPositiveInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Input ID:");
                                int sID = input.inputPositiveInt();
                                Doctor d = dao.search(a, sID);
                                if (d == null) {
                                    System.out.println("No result!");
                                } else {
                                    System.out.println(d);
                                }
                                con = false;
                                break;
                            case 2:
                                System.out.print("Input Name:");
                                String sName = input.inputNotEmptyString();
                                ArrayList<Doctor> arr = dao.search(a, sName);
                                if (arr.isEmpty()) {
                                    System.out.println("No result!");
                                } else {
                                    for (Doctor doctor : arr) {
                                        System.out.println(doctor);
                                    }
                                }
                                con = false;
                                break;
                            default:
                                System.out.println("Invalid! please choose action 1 or 2:");
                                con = true;
                                break;

                        }
                        if (con) {
                            continue;
                        } else {
                            break;
                        }
                    } while (true);
                    break;
                case 5:
                    Collections.sort(a, new DoctorDAO());
                    for (Doctor doctor : a) {
                        System.out.println(doctor);
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            // show menu
            menu();

        } while (true);
    }

    public static void menu() {
        System.out.println("\n1. Create a Doctor\n"
                + "2. Edit a Doctor Information\n"
                + "3. Delete a Doctor\n"
                + "4. Search doctor by ID and by Name\n"
                + "5. Sort doctor by DateOfBirth\n"
                + "0. Exit"
        );
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}
