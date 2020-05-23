/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Doctor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author dell
 */
public class DoctorDAO implements Comparator<Doctor> {
//    Create a Doctor 

    ValidateInput input = new ValidateInput();

    public void add(ArrayList<Doctor> a) {
        int ID = a.get(a.size() - 1).getID() + 1;
        System.out.println("Doctor " + ID);
        String name = input.inputName();
        Date dob = input.inputDOB();
        String spec = input.inputSpec();
        int availability = input.inputAvailability();
        String email = input.inputEmail();
        String phone = input.inputPhone();
        a.add(new Doctor(ID, name, dob, spec, availability, email, email));
    }
//    Edit a Doctor Information 

    public int getIndexOfDocter(ArrayList<Doctor> a, int ID) {
        for (int i = 0; i < a.size(); i++) {
            Doctor get = a.get(i);
            if (get.getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public void update(ArrayList<Doctor> a, int ID) {
        int index = getIndexOfDocter(a, ID);
        if (index == -1) {
            System.err.println("Doctor ID is not existed!");
        } else {
            String name = input.inputName();
            Date DOB = input.inputDOB();
            String spec = input.inputSpec();
            int avail = input.inputAvailability();
            String email = input.inputEmail();
            String mobile = input.inputPhone();
            if (isChange(a.get(index), name, DOB, spec, avail, email, mobile)) {
                a.get(index).setName(name);
                a.get(index).setDOB(DOB);
                a.get(index).setSpec(spec);
                a.get(index).setAvailability(avail);
                a.get(index).setEmail(email);
                a.get(index).setMobile(mobile);
                System.out.println("Update successful");
            } else {
                System.out.println("No change");
            }
            for (Doctor doctor : a) {
                System.out.println(doctor);
            }
        }
    }

    public boolean isChange(Doctor d, String name, Date DOB, String Spec, int avail, String email, String mobile) {
        if (d.getName().equals(name) && d.getDOB().compareTo(DOB) == 0 && d.getSpec().equals(Spec)
                && d.getAvailability() == avail && d.getEmail().equals(email) && d.getMobile().equals(mobile)) {
            return false;
        }
        return true;
    }
//    Delete a Doctor 

    public void delete(ArrayList<Doctor> a, int ID) {
        int index = getIndexOfDocter(a, ID);
        if (index == -1) {
            System.err.println("Doctor ID is not existed!");
        } else {
            a.remove(index);
            System.out.println("Delete successful");
            for (Doctor doctor : a) {
                System.out.println(doctor);
            }
        }
    }
//    Search doctor by ID and by Name 

    public Doctor search(ArrayList<Doctor> a, int ID, String name) {
        for (int i = 0; i < a.size(); i++) {
            Doctor get = a.get(i);
            if (get.getID() == ID && get.getName().equals(name)) {
                return get;
            }
        }
        return null;
    }
//    Sort doctor by DateOfBirth 

    @Override
    public int compare(Doctor o1, Doctor o2) {
        return o1.getDOB().compareTo(o2.getDOB());
    }

    public Doctor search(ArrayList<Doctor> a, int sID) {
        for (int i = 0; i < a.size(); i++) {
            Doctor get = a.get(i);
            if (get.getID() == sID) {
                return get;
            }
        }
        return null;
    }

    public ArrayList<Doctor> search(ArrayList<Doctor> a, String sName) {
        ArrayList<Doctor> arr = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            Doctor get = a.get(i);
            if (get.getName().toLowerCase().contains(sName.toLowerCase())) {
                arr.add(get);
            }
        }
        return arr;
    }

}
