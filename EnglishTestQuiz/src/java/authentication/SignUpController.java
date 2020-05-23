/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import dal.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Admin
 */
public class SignUpController extends HttpServlet {

    int randomCaptcha = -1;
    
//    String username = "";
//    String password = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        randomCaptcha = 100000 + new Random().nextInt(1000000);
        request.setAttribute("captcha", randomCaptcha);
        request.getRequestDispatcher("view/authentication/Signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String typedCaptcha = request.getParameter("typedcaptcha");
        int captcha = -1;
        if (typedCaptcha != null && typedCaptcha != "") {
            captcha = Integer.parseInt(typedCaptcha);
        }
        Account a = new Account();
        if (captcha == randomCaptcha) {
            DBContext db = new DBContext();
            if (!db.isExistedUsername(username)) {
                db.createAnAccount(username, password, 2);
                a.setUsername(username);
                a.setPassword(password);
                a.setRoleid(2);
                msg = "Sign up successfully!";
            } else {
                msg = "Username is existed";
                
            }
        } else if (captcha != -1) {
            msg = "Wrong captcha!";
        }
        
        request.setAttribute("msg", msg);
        if (msg.equals("Sign up successfully!")){
            request.getSession().setAttribute("currentaccount", a);
            response.getWriter().print(msg);
        }
        else{
            doGet(request, response);
            request.getRequestDispatcher("view/authentication/Signup.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
