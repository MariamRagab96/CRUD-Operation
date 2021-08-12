package com.mycompany.inventory.controller.user;

import com.mycompany.inventory.doa.entity.User;
import com.mycompany.inventory.doa.model.UserModel;
import com.mycompany.inventory.doa.model.impl.UserModelImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(userName + " " + password);
        UserModel userModel = new UserModelImpl();
        User user = userModel.findByUserAndPassword(userName, password);
        System.out.println("user " + user);
        if (user != null) {

            //req.getRequestDispatcher("SelectInventory").forward(req, resp);
            resp.sendRedirect("/inventory/SelectInventory");
        } else {
            String msg = "Invalid Username or Password Please Try again";
            System.out.println("msg : " + msg);
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }
    }
}
