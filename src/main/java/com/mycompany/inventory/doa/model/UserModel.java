/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inventory.doa.model;

import com.mycompany.inventory.doa.entity.User;
import java.util.List;

/**
 *
 * @author pc
 */
public interface UserModel {

    User updateUser(User user);

    int deleteUser(int id);

    List<User> retriveAllUsers();

    void createUser(User user);

    User findByUserAndPassword(String username, String password);
}
