
package com.mycompany.inventory.controller.servlet.inventory;

import com.mycompany.inventory.doa.entity.Inventory;
import com.mycompany.inventory.doa.model.InventoryModel;
import com.mycompany.inventory.doa.model.impl.InventoryModelImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "updateInventory", urlPatterns = "/updateInventory")
public class Update extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int myId = Integer.parseInt(id);
        req.getSession().setAttribute("myId", myId);
       resp.sendRedirect("UpdateInventory.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InventoryModel inventoryModel = new InventoryModelImpl();

        String item = req.getParameter("item");
        String bought = req.getParameter("bought");
        int b = Integer.parseInt(bought);
        String sold = req.getParameter("sold");
        int s = Integer.parseInt(sold);
        Inventory inventory = new Inventory(item, b, s);
        int id = (Integer) (req.getSession().getAttribute("myId"));
        inventory.setId(id);
        inventoryModel.update(inventory);
        resp.sendRedirect("SelectInventory");
    }
}
