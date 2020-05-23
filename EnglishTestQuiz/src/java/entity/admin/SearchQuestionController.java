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
import model.Test;

/**
 *
 * @author Admin
 */
public class SearchQuestionController extends HttpServlet {

    String testid = "";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        testid = request.getParameter("testID");
        request.getRequestDispatcher("/view/entity/admin/SearchQuestion.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        DBContext db = new DBContext();
//        ArrayList<Test> tests = new ArrayList<>();
//        String gettestid = request.getParameter("testid");
//        int testid = -1;
//        if (!gettestid.equals("")) {
//            testid = Integer.parseInt(gettestid);
//        }
//        
//        String testname = request.getParameter("testname");
//        String usercreated = request.getParameter("usercreated");
//        
//        String getquestionid = request.getParameter("questionid");
//        int questionid = -1;
//        if (!getquestionid.equals("")) {
//            questionid = Integer.parseInt(getquestionid);
//        }
//        
//        String question = request.getParameter("question");
//        String option1 = request.getParameter("option1");
//        String option2 = request.getParameter("option2");
//        String option3 = request.getParameter("option3");
//        String correct = request.getParameter("correct");
//        tests = db.search(testid, testname, usercreated, questionid, question, option1, option2, option3, correct);
//        request.setAttribute("tests", tests);
//        request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
          
            }
    

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
