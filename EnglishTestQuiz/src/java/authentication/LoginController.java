/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import dal.DBContext;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/authentication/Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBContext db = new DBContext();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String msg = "";
        Account a = new Account();

        if (username.equals("")) {
            msg = "Please enter username!"+"\n";
        }
        if (password.equals("")) {
            msg = "Please enter password!";
        }
        if (username.equals("")&&password.equals("")) {
            msg = "Please enter username and password!";
        }
        if (msg.equals("")) {
//            DBContext db = new DBContext();
            a = db.getAccountByUsernameAndPassword(username, password);
            if (a == null) {
                msg = "Wrong username or password!";
            } else {
                msg = "Hello " + username;
                request.getSession().setAttribute("currentaccount", a);
            }
        }

        request.setAttribute("msg", msg);
        if (msg.equals("Hello " + username)) {
            ArrayList<Test> tests = db.getAllTestsByFilter(-1, "", "");
            request.setAttribute("tests", tests);
            if (a.getRoleid() == 1) {
                
                request.getRequestDispatcher("/view/entity/admin/ListAdmin.jsp").forward(request, response);
            }
            if (a.getRoleid() == 2) {
                request.getRequestDispatcher("/view/entity/client/ListAllTest.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("view/authentication/Login.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
