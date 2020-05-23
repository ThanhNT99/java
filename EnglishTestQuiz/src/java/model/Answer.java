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
public class Answer {
    private int id;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public Answer() {
    }

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", answer=" + answer + '}';
    }
    
}
