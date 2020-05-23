/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Test {
    private int testID;
    private String name;
    private String usercreated;
    private ArrayList<Question> arrQues = new ArrayList<>();

    public Test() {
    }

    public Test(int testID, String name, Question q, String usercreated) {
        this.testID = testID;
        this.name = name;
        this.arrQues.add(q);
        this.usercreated = usercreated;
    }

    public String getUsercreated() {
        return usercreated;
    }

    public void setUsercreated(String usercreated) {
        this.usercreated = usercreated;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getArrQues() {
        return arrQues;
    }

    public void setArrQues(Question q) {
        this.arrQues.add(q);
    }

    @Override
    public String toString() {
        return "Test{" + "testID=" + testID + ", name=" + name + ", usercreated=" + usercreated + ", arrQues=" + arrQues + "}\n";
    }
    
}
