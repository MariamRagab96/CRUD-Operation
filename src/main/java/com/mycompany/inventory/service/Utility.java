package com.mycompany.inventory.service;

import com.mycompany.inventory.doa.model.UserModel;
import com.mycompany.inventory.doa.model.impl.UserModelImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {

    public static boolean isUserNameExist(String username) {
        UserModel userModel = new UserModelImpl();
        return userModel.isUserNameExist(username);

    }

}
