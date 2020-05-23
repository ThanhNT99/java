/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.client;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Answer;
import model.Question;

/**
 *
 * @author Admin
 */
public class SubmitTest extends HttpServlet {

    String testID = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        int count=0;
        testID =(String) request.getParameter("tid");
        System.out.println("iddddddd="+testID);
        ArrayList<Question> questions = db.getQuestionsByFilter(Integer.parseInt(testID), -1, "", "", "", "", "");
        ArrayList<Answer> corrects = db.getAnswerList(Integer.parseInt(testID));
        ArrayList<Answer> clientAnswer = new ArrayList<>();
//        for (Question question : questions) {
//            String answer = request.getParameter(question.getQuestionID()+"");
//            clientAnswer.add(new Answer(question.getQuestionID(), answer));
//        }
        for (int i = 0; i < corrects.size(); i++) {
            String answerClient = request.getParameter(corrects.get(i).getId()+"");
            if (answerClient != null) {
                if (answerClient.equals(corrects.get(i).getAnswer())){
                    count++;
                }
                clientAnswer.add(new Answer(corrects.get(i).getId(), answerClient));
            } else {
                clientAnswer.add(new Answer(corrects.get(i).getId(), null));
            }
        }
        
        double percent = count/corrects.size();
        String msg = "";
        msg+= "You got " + count +"/" + corrects.size()+". ";
        if (percent==1){
            msg += "You did excellent!";
        }
        if (percent<1 && percent>=0.8){
            msg += "Well done!";
        }
        if (percent<0.8 && percent>=0.5){
            msg += "Good luck next time!";
        }
        if (percent<0.5){
            msg += "Try harder!";
        }
        request.setAttribute("msg", msg);
        request.setAttribute("questions", questions);
        request.setAttribute("clientAnswer",clientAnswer);
        request.getRequestDispatcher("/view/entity/client/ResultTest.jsp").forward(request, response);

//        request.getRequestDispatcher("/view/entity/client/ResultTest.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
