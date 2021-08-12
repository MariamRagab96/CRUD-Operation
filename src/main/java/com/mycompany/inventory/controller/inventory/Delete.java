/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory.controller.inventory;

import com.mycompany.inventory.doa.entity.Inventory;
import com.mycompany.inventory.doa.model.InventoryModel;
import com.mycompany.inventory.doa.model.impl.InventoryModelImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteInventory", urlPatterns = "/DeleteInventory")
public class Delete extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InventoryModel inventoryModel = new InventoryModelImpl();
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        inventoryModel.delete(i);
        req.getRequestDispatcher("SelectInventory").include(req, resp);
    }

}
