package com.db;

import com.db.mysql.Query;
import com.db.mysql.QueryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UserDao {
    Connection conn = null;
    PreparedStatement ps = null;

    Map<String, String> env = System.getenv();
    String dbPw = env.get("DB_PASSWORD");
    String dbUser = env.get("DB_USER");
    String dbHost = env.get("DB_HOST");

    Query query = new QueryImpl();
    public void add() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(dbHost, dbUser, dbPw);
        ps = conn.prepareStatement("insert into users(id, name, password) values (?, ?, ?)");
        ps.setString(1, "1");
        ps.setString(1, "hello");
        ps.setString(1, "13323");

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void userSelectOne() throws SQLException, ClassNotFoundException{
        conn = DriverManager.getConnection(dbHost, dbUser, dbPw);
        PreparedStatement ps = conn.prepareStatement(query.userSelectOne());
        ps.setInt(1, 1);

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserDao userDao = new UserDao();
        userDao.add();
    }
}


