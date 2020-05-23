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
public class SearchTestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/entity/admin/SearchTest.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        ArrayList<Test> tests = new ArrayList<>();
        String gettestid = request.getParameter("testid");
        int testid = -1;
        if (!gettestid.equals("")) {
            testid = Integer.parseInt(gettestid);
        }
        
        String testname = request.getParameter("testname");
        String usercreated = request.getParameter("usercreated");
        
       
        tests = db.getAllTestsByFilter(testid, testname, usercreated);
        request.setAttribute("tests", tests);
        request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
