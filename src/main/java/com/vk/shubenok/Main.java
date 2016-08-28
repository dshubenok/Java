package com.vk.shubenok;

import com.vk.shubenok.database.DBHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    private static DBHandler handler = new DBHandler(DBWorkerSingleton.getInstance());

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] commands;

        try {
            while(true) {
                String line = reader.readLine();
                if (line.equals("exit")) break;
                commands = line.split(" ");
                checkCommand(commands);
            }

            handler.getData();
            reader.close();
            DBWorkerSingleton.getInstance().getConnection().close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkCommand(String[] commands) {
        if (commands[0].equals("add") & commands.length >= 2) {
            handler.insertData(commands[1], commands[2]);
        }
    }
}
