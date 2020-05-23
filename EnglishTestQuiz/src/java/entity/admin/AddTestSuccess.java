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
public class AddTestSuccess extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("here");
        String[] arr = request.getAttribute("arr").toString().split("\n");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("\n", "");
            System.out.println("arr["+i+"]="+arr[i]);
        }
//        int testid = Integer.parseInt(arr[0]);
//        String name = arr[1];
//        String usercreated = arr[2];
//        DBContext db = new DBContext();
//        db.insertTest(testid, name, usercreated);
//        ArrayList<Test> tests = db.getAllTestsByFilter(-1, "", "");
//        request.setAttribute("tests", tests);
//        request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
    }

    
 
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
