package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cena.jsp");
        getServletContext().setAttribute("user",user);

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String name = req.getParameter("Name");
    String email = req.getParameter("Email");
    String password = req.getParameter("Password");
    Integer number =  Integer.parseInt(req.getParameter("Number"));

    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cena.jsp");
    User user = new User();
    user.setName(name);
    user.setPassword(password);
    user.setEmail(email);
    user.setNumber(number);
    req.setAttribute("user", user);
    dispatcher.forward(req,resp);

    }
}
