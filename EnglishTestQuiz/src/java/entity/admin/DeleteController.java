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
public class DeleteController extends HttpServlet {

    String testid = "";
    ArrayList<Test> tests = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        testid = request.getParameter("testID");
        request.getRequestDispatcher("../view/entity/admin/Delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        if (!testid.equals("")) {
            db.deleteTest(Integer.parseInt(testid));
        }
        tests = db.getAllTestsByFilter(-1, "", "");
        request.setAttribute("tests", tests);
        request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
