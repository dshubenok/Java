package com.vk.shubenok.database;

interface DBCommands {
    String INSERT_NAME_PHONE =
            "INSERT INTO telephone_directory.users " +
                    "(first_name, phone) " +
                    "VALUES(?,?)";
    String INSERT_ALL =
            "INSERT INTO telephone_directory.users " +
                    "(first_name, phone, last_name) " +
                    "VALUES(?,?,?)";
}
