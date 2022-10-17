package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UserDao {
    public void add() throws SQLException, ClassNotFoundException {
        Map<String, String> env = System.getenv();
        String dbPw = env.get("DB_PASSWORD");
        String dbUser = env.get("DB_USER");
        String dbHost = env.get("DB_HOST");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPw);
        PreparedStatement ps = conn.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        ps.setString(1, "1");
        ps.setString(1, "hello");
        ps.setString(1, "13323");

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao userDao = new UserDao();
        userDao.add();
    }
}


