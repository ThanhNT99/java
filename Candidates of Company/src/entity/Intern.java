/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Intern extends Candidates {

    private String majors;
    private int semester;
    private String nameUni;

    public Intern() {
    }

    public Intern(Candidates c, String majors, int semester, String nameUni) {
        super(c.getID(), c.getFirstName(), c.getLastName(), c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), 2);
        this.majors = majors;
        this.semester = semester;
        this.nameUni = nameUni;
    }

    public Intern(String ID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, String majors, int semester, String nameUni) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.nameUni = nameUni;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getNameUni() {
        return nameUni;
    }

    public void setNameUni(String nameUni) {
        this.nameUni = nameUni;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + majors + "|" + semester + "|" + nameUni;
    }

}
