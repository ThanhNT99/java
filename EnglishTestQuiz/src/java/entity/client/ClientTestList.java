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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Test;

/**
 *
 * @author Admin
 */
public class ClientTestList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String testid = request.getParameter("testID");
        String username = ((Account) request.getSession().getAttribute("currentaccount")).getUsername();
        DBContext db = new DBContext();
        if (testid != null) {
            db.insertClientTest(username, Integer.parseInt(testid));
            ArrayList<Test> tests = db.getAllTestsByFilter(-1, "", "");
            request.setAttribute("tests", tests);
            request.getRequestDispatcher("/view/entity/client/ListAllTest.jsp").forward(request, response);
        }
        else{
            ArrayList<Test> tests = db.getAllTestListofClient(username);
            request.setAttribute("tests", tests);
            request.getRequestDispatcher("/view/entity/client/ClientTestList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
