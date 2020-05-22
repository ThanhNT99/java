/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ValidateInput {
    public String inputNotEmptyString() {
        Scanner t = new Scanner(System.in);
        while (true) {
            String val = t.nextLine().trim();
            if (val.isEmpty()) {
                System.out.println("Enter string<not empty>: ");
                continue;
            }
            return val;
        }
    }

    public int inputPositiveInt() {
        Scanner t = new Scanner(System.in);
        int val = 0;
        while (val<=0) {
            try {
                val = Integer.parseInt(t.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please enter integer number: ");
                continue;
            }
        }
        return val;
    }
    
    public int inputPositiveIntFromTo (int from, int to){
        int val;
        do {            
            val = inputPositiveInt();
            if (val > to || val < from) 
            {
                System.err.println("Please enter integer number from " + from + " to " + to + ": ");
            }
        } while (val > to || val < from);
        return val;
    }

    public String inputYN() {
        Scanner t = new Scanner(System.in);
        String yn;
        do {
            System.out.println("Enter y/n: ");
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
        
        while (true)
        {
            String name = inputNotEmptyString();
            if (!name.matches("[a-zA-Z ]+"))
                    {
                        System.out.println("Enter string<contains A-Z or a-z>: ");
                        continue;
                    }
            return process(name);
        }
        
    }
    
    public String inputID(){
        String ID = inputNotEmptyString();
        return ID;
    }
    
    public int inputDate(int begin, int end){
        int date;
        do{
            date = inputPositiveInt();
            if (date<begin || date>end){
                System.out.println("Out of range ["+begin+","+end+"]!  Please re-enter: ");
            }
        } while (date<begin || date>end);
        return date;
    }
    
    public String inputPhone(){
        String s="";
        do{
            s = inputNotEmptyString();
            if (!s.matches("[0-9+]") && s.length()<10){
                System.err.println("Only number [0-9] with minimum 10 numbers. Re-enter: ");
            }
            else return s;
        }while(true);
    }
    
    public String inputEmail(){
        String s, EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        do{
            s = inputNotEmptyString();
            if (!s.matches(EMAIL_REGEX)){
                System.out.println("Wrong format email. Re-enter: ");
            }
            else return s;
        } while (true);
    }

}
