package checkinput;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class CheckInput {

    public String inputNotEmptyString() {
        Scanner t = new Scanner(System.in);
        while (true) {
            String val = t.nextLine().trim();
            if (val.isEmpty()) {
                System.err.println("Enter string<not empty>: ");
                continue;
            }
            return val;
        }
    }

    public int inputPositiveInt() {
        Scanner t = new Scanner(System.in);
        int val = 0;
        while (val <= 0) {
            try {
                val = Integer.parseInt(t.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Enter must integer number: ");
                continue;
            }

        }
        return val;
    }

    public double inputPositiveDouble() {
        Scanner t = new Scanner(System.in);
        double val = 0;
        do {
            try {
                val = Double.parseDouble(t.nextLine());
                if (val <= 0) {
                    System.err.print("Just be enter positive double value: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.err.print("Just be enter positive double value: ");
                continue;
            }

        } while (true);

        return val;

    }

    public String inputYN() {
        Scanner t = new Scanner(System.in);
        String yn;
        do {
            System.out.print("Enter y/n: ");
            yn = inputNotEmptyString();
            if (!yn.equalsIgnoreCase("y") & !yn.equalsIgnoreCase("n")){
                System.err.println("Only enter y/n!");
            }
            else break;
        } while (true);

        if (yn.equalsIgnoreCase("y")) {
            return "y";
        }
        return "n";

    }

    public String process(String name) {
        String result = "", temp = "";
        name = name.trim().replaceAll("\\s+", " ").toLowerCase();
        String[] arr = name.split(" ");
        for (int i = 0; i < arr.length; i++) {
            result += arr[i].valueOf(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1);
            if (i < arr.length - 1) {
                result += " ";
            }

        }
        return result;
    }

    public String inputName() {

        while (true) {
            String name = inputNotEmptyString();
            if (!name.matches("[a-zA-Z ]+")) {
                System.err.println("Enter string<contains A-Z or a-z>: ");
                continue;
            }
            return process(name);
        }

    }
}
