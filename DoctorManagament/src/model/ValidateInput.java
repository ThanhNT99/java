/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class ValidateInput {

    public String inputNotEmptyString() {
        Scanner t = new Scanner(System.in);
        while (true) {
            String val = t.nextLine().trim();
            if (val.isEmpty()) {
                System.err.println("Enter value <not empty>: ");
                continue;
            }
            return val;
        }
    }

    public int inputPositiveInt() {
        Scanner t = new Scanner(System.in);
        int val = -1;
        do {
            try {
                val = Integer.parseInt(inputNotEmptyString());
                break;
            } catch (NumberFormatException e) {
                System.err.print("Enter must integer number: ");
                continue;
            }

        } while (val < 0);
        return val;
    }

    public String inputYN() {
        Scanner t = new Scanner(System.in);
        String yn;
        do {
            System.out.print("Enter y/n: ");
            yn = inputNotEmptyString();
        } while (!yn.equalsIgnoreCase("y") & !yn.equalsIgnoreCase("n"));

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
        System.out.println("Input Name: ");
        while (true) {
            String name = inputNotEmptyString();
            //if (!name.matches("[a-zA-Z ]+") || name.length() > 50) {
            if (name.length() > 50){
            //    System.err.println("Enter string<contains A-Z or a-z> and not longer than 50 characters: ");
                System.err.println("Enter string not longer than 50 characters: ");
                continue;
            }
            //return process(name);
            return name;
        }

    }

    public String inputSpec() {
        System.out.println("Input Specialization: ");
        while (true) {
            String spec = inputNotEmptyString();
            //if (!spec.matches("[a-zA-Z ]+") || spec.length() > 255) {
            if (spec.length() > 255){
                //System.err.println("Enter string<contains A-Z or a-z> and not longer than 255 characters: ");
                System.err.println("Enter string not longer than 255 characters: ");
                continue;
            }
            return spec;
        }

    }
//(000)-000-0000 format

    public String inputPhone() {
        String s = "";
        System.out.print("Input Phone Number: ");
        do {
            s = inputNotEmptyString();
            //\(\d{3}\)\d{3}-?\d{4}
            if (!s.matches("^\\(\\d{3}\\)-\\d{3}-\\d{4}$")) {
                System.err.println("Only (000)-000-0000 format. Re-enter: ");
            } else {
                return s;
            }
        } while (true);
    }

    public String inputEmail() {
        String s, EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        System.out.print("Input Email: ");
        do {
            s = inputNotEmptyString();
            if (!s.matches(EMAIL_REGEX)) {
                System.err.print("Wrong format email. Re-enter: ");
            } else {
                return s;
            }
        } while (true);
    }

    public int inputAvailability() {
        int a;
        System.out.println("Input Availability (0-3): ");
        while (true) {
            a = inputPositiveInt();
            if (a < 0 || a > 3) {
                System.err.println("Availability must be from 0 to 3. Re-enter: ");
                continue;
            }
            return a;
        }
    }

    public String convertAvailability(int availability) {
        /* 0 for in vacation, 1 for available, 2 for busy in emergency case, 3 for in diagnosing case. */

        if (availability == 0) {
            return "In vacation";
        } else if (availability == 1) {
            return "Available";
        } else if (availability == 2) {
            return "busy in emergency case";
        } else {
            return "In diagnosing case";
        }
    }

    public Date inputDOB() {
        System.out.println("Input DOB (\"dd/MM/yyyy\"): ");
        do {
            String dob = inputNotEmptyString();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
            try {
                return (df.parse(dob)); // parse dob thành kiểu Date
            } catch (ParseException e) { // quăng lỗi nếu dob ko hợp lệ
                System.err.println("Invalid date (\"dd/MM/yyyy\"). Re-enter: ");
                continue;
            }

        } while (true);
    }
}
