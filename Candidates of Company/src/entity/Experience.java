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
public class Experience extends Candidates {

    private int expInYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(Candidates c, int expInYear, String proSkill) {
        super(c.getID(), c.getFirstName(), c.getLastName(), c.getBirthDate(), c.getAddress(), c.getPhone(), c.getEmail(), 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public Experience(String ID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, int expInYear, String proSkill) {
        super(ID, firstName, lastName, birthDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "|" + expInYear + "|" + proSkill;
    }

}
