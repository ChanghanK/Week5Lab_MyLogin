/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import main.Account;
import main.User;

/**
 *
 * @author 827637
 */
public class LoginServlet extends HttpServlet {
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String logout = (String) request.getParameter("logout");
        
        if (logout != null && logout.equals("logout")){
            request.setAttribute("login", "You have successfully logged out");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        User user = (User) session.getAttribute("user");
        
        if (user != null){
            response.sendRedirect("home");
        } else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User();
        
        Account account = new Account();
        
        if (username != null && password != null){
            user = account.login(username, password);
        }
        
        if (user != null){
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user", user);
            response.sendRedirect("home");
        } else{
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("login", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
