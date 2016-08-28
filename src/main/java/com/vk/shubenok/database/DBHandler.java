package com.vk.shubenok.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler implements DBCommands {
    public DBHandler() {
    }

    public void insertData(String firstName, String phone) {
        insertData(firstName, null, phone);
    }

    public void insertData(String firstName, String lastName, String phone) {
        try (Connection con = ConnectionSingleton.getConnection();
             PreparedStatement pr = con.prepareStatement(checkInsert(lastName))) {

            pr.setString(1, firstName);
            pr.setString(2, phone);
            if (lastName != null) pr.setString(3, lastName);

            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String checkInsert(String lastName) {
        if (lastName == null) return INSERT_NAME_PHONE;
        return INSERT_ALL;
    }
}
