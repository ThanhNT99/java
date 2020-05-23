package main;


import java.io.IOException;
import process.Process;
import process.FileMethod;
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        String s = "     as you can see      ,     Detecting whether efficient.a lot in the“   second row   ”  buffers.the cost strings."+"\n"+"\n"+"\n"+"\n"+"as it turns out, These, even futher"+"\n" +"nguyen thanh thanh";
//        String s = "     (    Thanh Thanh     )         as you can see,detecting whether a string     is normalized can be quite efficient.      a lot of the cost of normalizing in the\n"
//                + "“    second row     ” is for the   (THANH) initialization of buffers      .     The cost of:       which is amortized when one is processing larger strings\n"
//                + " As it turns out    , these Buffers Are rarely needed      ,     so we may change the implementation at some point to speed up the\n\n\n                     "
//                + " common case for small Strings even further(thanh )        ";
        FileMethod fm = new FileMethod();
        String s = (String) fm.readDataFromFile("input.txt");
        Process p = new Process();
        System.out.println(p.process(s));
        fm.writeDataToFile((String)p.process(s), "output.txt");
    }
    
}
