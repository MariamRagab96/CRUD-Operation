
package com.mycompany.inventory.controller.servlet.inventory;

import com.mycompany.inventory.doa.entity.Inventory;
import com.mycompany.inventory.doa.model.InventoryModel;
import com.mycompany.inventory.doa.model.impl.InventoryModelImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SelectInventory", urlPatterns = "/SelectInventory")
public class Select extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InventoryModel inventoryModel = new InventoryModelImpl();

        List<Inventory> myList = inventoryModel.retriveAll();
        req.setAttribute("list", myList);
        System.out.println("************");
         req.getRequestDispatcher("InventoryShow.jsp").include(req, resp);
//        resp.sendRedirect("InsertInventory.jsp");
    }
}
