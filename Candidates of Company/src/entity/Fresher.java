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
public class Fresher extends Candidates {

    private int graduateTime;
    private String graduateRank;
    private String university;

    public Fresher() {
    }

    public Fresher(Candidates c, int graduateTime, String graduateRank, String university) {
        super(c.getID(), c.getFirstName(), c.getLastName(), c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), 1);
        this.graduateTime = graduateTime;
        this.graduateRank = graduateRank;
        this.university = university;
    }

    public Fresher(String ID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, int graduateTime, String graduateRank, String university) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.graduateTime = graduateTime;
        this.graduateRank = graduateRank;
        this.university = university;
    }

    public int getGraduateTime() {
        return graduateTime;
    }

    public void setGraduateTime(int graduateTime) {
        this.graduateTime = graduateTime;
    }

    public String getGraduateRank() {
        return graduateRank;
    }

    public void setGraduateRank(String graduateRank) {
        this.graduateRank = graduateRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + graduateTime + "|" + graduateRank + "|" + university;
    }

}
