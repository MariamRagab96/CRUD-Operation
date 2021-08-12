package com.mycompany.inventory.controller.user;

import com.mycompany.inventory.service.Utility;
import com.mycompany.inventory.doa.entity.User;
import com.mycompany.inventory.doa.model.UserModel;
import com.mycompany.inventory.doa.model.impl.UserModelImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register", urlPatterns = "/register")
public class Registration extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserModel userModel = new UserModelImpl();
        if (Utility.isUserNameExist(username)) {
            String msg = " The username already exists Please Try again ";
            System.out.println("msg : " + msg);
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("InsertUser.jsp").include(req, resp);
        } else {

            User user = new User(username, password);
            userModel.createUser(user);
            resp.sendRedirect("/inventory/SelectInventory");
        }

    }
}
