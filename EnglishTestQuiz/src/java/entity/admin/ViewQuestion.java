/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.admin;

import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author Admin
 */
public class ViewQuestion extends HttpServlet {

    String testid = "";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        testid = request.getParameter("testID");
        System.out.println("testid"+testid);
        ArrayList<Question> questions = db.getQuestionsByFilter(Integer.parseInt(testid),-1, "","","","","");
        for (Question question : questions) {
            System.out.println(question);
        }
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("/view/entity/admin/ListQuestion.jsp").forward(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
