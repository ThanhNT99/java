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
import model.Test;

/**
 *
 * @author Admin
 */
public class ListAllTest extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        ArrayList<Test> tests = db.getAllTestsByFilter(-1, "", "");
        request.setAttribute("tests", tests);
        request.getRequestDispatcher("/view/entity/client/ListAllTest.jsp").forward(request, response);
    }

//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        request.getRequestDispatcher("/view/entity/client/ListClient.jsp").forward(request, response);
//    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
