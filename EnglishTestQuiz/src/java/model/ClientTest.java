/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ClientTest {
    private String username;
    private int testid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public ClientTest() {
    }

    public ClientTest(String username, int testid) {
        this.username = username;
        this.testid = testid;
    }

    @Override
    public String toString() {
        return "ClientTest{" + "username=" + username + ", testid=" + testid + '}';
    }
    
}
