package servlet;

import daoService.impl.UserServiceImplementation;
import daoService.UserService;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImplementation.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("login");
        String pass = request.getParameter("pass");

        User user = userService.getUserByMail(email);


        if(user != null && user.getPassword().equals(pass)){
            request.setAttribute("email", email);
            request.getRequestDispatcher("cabinet.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
