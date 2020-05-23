package process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.ArrayList;
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
public class FileMethod {

    public void writeDataToFile(String s, String fileName) {
        File file = new File(fileName);
        try {

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String[] arr = s.split("\n");
            for (int i = 0; i < arr.length; i++) {
                bufferedWriter.write(arr[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public String readDataFromFile(String fileName) throws IOException {
        String s = "";
        Reader reader = new FileReader(fileName);

        try (LineNumberReader lineNumberReader = new LineNumberReader(reader)) {
            String line = lineNumberReader.readLine();
            while (line != null) {
                s += line + "\n";
                line = lineNumberReader.readLine();
            }

        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        return s;
    }
}
