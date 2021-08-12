/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory.doa.model.impl;

import com.mycompany.inventory.doa.config.ConnectionDB;
import com.mycompany.inventory.doa.entity.Inventory;
import com.mycompany.inventory.doa.entity.User;
import com.mycompany.inventory.doa.model.InventoryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryModelImpl implements InventoryModel {

    private final String INSERT = "INSERT INTO INVENTORY (ITEM,BOUGHT,SOLD) VALUES (?,?,?)";
    private final String DELETE = "DELETE FROM INVENTORY WHERE ID = ?";
    private final String SELECT_ALL = "SELECT * FROM INVENTORY";
    private final String SELECT_ONE = "SELECT * FROM INVENTORY WHERE ID = ?";
    private final String UPDATE = "UPDATE INVENTORY SET ITEM=? , BOUGHT=?, SOLD=? WHERE ID =?";
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public InventoryModelImpl() {
        connection = ConnectionDB.getInstance().getConnection();

    }

    public static void main(String[] args) {
        InventoryModel i = new InventoryModelImpl();
        System.out.println(i.retriveById(3));
//        Inventory inventory = new Inventory("Dress", 10, 20);
//        System.out.println(i.update(inventory));
//        System.out.println(i.delete(1));
    }

    @Override
    public int update(Inventory inventory) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, inventory.getItem());
            preparedStatement.setInt(2, inventory.getBought());
            preparedStatement.setInt(3, inventory.getSold());
            preparedStatement.setInt(4, inventory.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<Inventory> retriveAll() {
        List<Inventory> inventorys = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Inventory inventory = new Inventory();
                inventory.setId(resultSet.getInt("ID"));
                inventory.setItem(resultSet.getString("ITEM"));
                inventory.setBought(resultSet.getInt("BOUGHT"));
                inventory.setSold(resultSet.getInt("SOlD"));

                inventorys.add(inventory);
            }
            return inventorys;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventorys;
    }

    @Override
    public void insert(Inventory inventory) {
        int id = -1;
        try {

            preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, inventory.getItem());
            preparedStatement.setInt(2, inventory.getBought());
            preparedStatement.setInt(3, inventory.getSold());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            inventory.setId(id);
            System.out.println("Inventory insert successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Inventory retriveById(int id) {
        Inventory inventory = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ONE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                inventory = new Inventory();
                inventory.setId(resultSet.getInt("ID"));
                inventory.setItem(resultSet.getString("ITEM"));
                inventory.setBought(resultSet.getInt("BOUGHT"));
                inventory.setSold(resultSet.getInt("SOlD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InventoryModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventory;
    }
}
