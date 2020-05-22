/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import checkInput.CheckInputCandidate;
import entity.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Functions {
    CheckInputCandidate checkInput= new CheckInputCandidate();
    public int findByID(ArrayList<Candidates> list, String ID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }
    
    public String NotDupID(ArrayList<Candidates> list){
        String ID = "";
        do{
            ID = checkInput.inputNotEmptyString();
            if (findByID(list, ID)!=-1){
                System.out.print("Duplicated ID. Re-enter: ");
            }
            else break;
        }while (true);
        return ID;
    }
    public Candidates createCandidatesWithID(ArrayList<Candidates> list){
        // Candidate Id, First Name, Last Name, Birth Date, Address, Phone, Email and Candidate type
        System.out.println("Input ID: ");
        String ID = NotDupID(list);
        System.out.print("Input first name: ");
        String firstName = checkInput.inputName();
        System.out.print("Input last name: ");
        String lastName = checkInput.inputName();
        System.out.print("Input birth date (1900-2019): ");
        int birthDate =  checkInput.inputDate(1900, 2019);
        System.out.print("Input address: ");
        String address = checkInput.inputNotEmptyString();
        System.out.print("Input phone: ");
        String phone = checkInput.inputPhone();
        System.out.print("Input email: ");
        String email = checkInput.inputEmail();
        Candidates c =  new Candidates(ID, firstName, lastName, birthDate, address, phone, email);
        return c;
    }
    public void addExperience( ArrayList<Candidates> listC){
        //type = 0, year of experience (ExpInYear), Professional Skill (ProSkill). 
        Candidates c = createCandidatesWithID(listC);
        System.out.print("Input year of experience: ");
        int expInYear = checkInput.inputDate(0, 100);
        System.out.print("Input Professional Skill: ");
        String proSkill = checkInput.inputNotEmptyString();
        listC.add(new Experience(c, expInYear, proSkill));
    }
    
    public void addFresher( ArrayList<Candidates> listC){
        //graduated time (Graduation_date), Rank of Graduation (Graduation_rank) and university where student graduated (Education)
        Candidates c = createCandidatesWithID(listC);
        System.out.println("Input graduated time: ");
        int graDate = checkInput.inputDate(1900, 2018);
        System.out.println("Input Rank of Graduation: ");
        String rank = checkInput.inputRank();
        System.out.println("Input university where graduated: ");
        String uni = checkInput.inputNotEmptyString();
        listC.add(new Fresher(c, graDate, rank, uni));
        
    }
    
    public void addIntern( ArrayList<Candidates> listC){
        //Majors, Semester, University name
        Candidates c = createCandidatesWithID(listC);
        System.out.println("Input majors: ");
        String major = checkInput.inputNotEmptyString();
        System.out.println("Input semester: ");
        int semester = checkInput.inputPositiveInt();
        System.out.println("Input university name: ");
        String uni = checkInput.inputNotEmptyString();
        listC.add(new Intern(c, major, semester, uni));
        
    }
    
    public void searchByNameAndType(ArrayList<Candidates> list, String name, int type){
        for (Candidates c : list) {
            String s = (c.getFirstName() + c.getLastName()).toLowerCase();
            if (s.contains(name.toLowerCase()) && c.getType()==type){
                System.out.println(c);
            }
        }
    }
}
