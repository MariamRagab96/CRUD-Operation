package com.mycompany.inventory.doa.model.impl;

import com.mycompany.inventory.doa.config.ConnectionDB;
import com.mycompany.inventory.doa.entity.User;
import com.mycompany.inventory.doa.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserModelImpl implements UserModel {

    private final String INSERT_USER = "INSERT INTO USER (USERNAME,PASSWORD) VALUES (?,?)";
    private final String DELETE_USER = "DELETE FROM USER WHERE ID = ?";
    private final String SELECT_ALL = "SELECT * FROM USER";
    private final String SELECT_BY_USER_AND_PASSWORD = "SELECT * FROM USER WHERE USERNAME = ? "
            + "AND PASSWORD = ?";
    private final String SELECT_BY_USER = "SELECT USERNAME FROM USER WHERE USERNAME = ? ";
    private final String UPDATE_USER = "UPDATE USER SET USERNAME=? , PASSWORD=? WHERE ID =?";
    private Connection connection;
    private PreparedStatement preparedStatement = null;

    public UserModelImpl() {
        connection = ConnectionDB.getInstance().getConnection();

    }

    // for testing 
    public static void main(String[] args) {
        UserModelImpl u = new UserModelImpl();
        User user = new User("Mariam2244", "1232");
        //u.createUser(user);
        // System.out.println(u.deleteUser(2));
        //System.out.println(user.getId());
        //System.out.println(u.retriveAllUsers());
        System.out.println(u.findByUserAndPassword("Mariam2244", "1232"));
        System.out.println(u.findByUserAndPassword("Mariam", "1239999999"));
        System.out.println("hello");
    }

    @Override
    public User updateUser(User user) {

        try {
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findByUserAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public int deleteUser(int id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getInstance().closeConnection();
        }

        return 0;
    }

    @Override
    public List<User> retriveAllUsers() {

        List<User> users = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getInstance().closeConnection();
        }
        return users;
    }

    @Override
    public void createUser(User user) {
        int id = -1;
        try {

            preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            System.out.println("resultSet : " + resultSet);
            System.out.println("resultSet.next() : " + resultSet.next());
            if (resultSet.next()) {

                id = resultSet.getInt(1);
            }
            user.setId(id);
            System.out.println("User insert successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getInstance().closeConnection();
        }

    }

    @Override
    public User findByUserAndPassword(String username, String password) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_USER_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.getInstance().closeConnection();
        }
        return user;
    }

    @Override
    public boolean isUserNameExist(String username) {
        boolean res = false;
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_USER);
            preparedStatement.setString(1, username);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            res = resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(UserModelImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
