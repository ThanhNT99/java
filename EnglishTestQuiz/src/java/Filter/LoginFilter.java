package Filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dal.DBContext;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Test;

/**
 *
 * @author Admin
 */
@WebFilter(urlPatterns = {"/entityAdmin/*", "/entityClient/*", "/view/entity/admin/*", "/view/entity/client/*"})
public class LoginFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    public LoginFilter() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        DBContext db = new DBContext();
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("currentaccount") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (loggedIn || loginRequest) {
            String requestPath = request.getServletPath();
            Account a = (Account) session.getAttribute("currentaccount");
            ArrayList<String> role_feature = a.getServletpath();
            int indexStart = requestPath.lastIndexOf("/");
            int indexEnd = requestPath.length();
            if (requestPath.contains(".")) {
                indexEnd = requestPath.lastIndexOf(".");
            }
            String f = indexEnd == requestPath.length() ? requestPath.substring(indexStart) : requestPath.substring(indexStart, indexEnd);
            boolean flag = false;

            for (String rf : role_feature) {
                if (rf.equalsIgnoreCase(f)) {
                    flag = true;
                    chain.doFilter(req, res);
                }

            }

            if (flag == false) {
                response.sendRedirect("http://localhost:8080/Assignment/colorlib-error-404-3/AccessDenied.html");
            }

        } else {
            response.sendRedirect(loginURI);
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {

    }

    /**
     * Return a String representation of this object.
     */
}
