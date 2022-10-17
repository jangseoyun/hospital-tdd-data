package com.project.dao;

import com.db.mysql.ConnectionDB;
import com.db.mysql.Query;
import com.project.query.HospitalQueryImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public UserDao() throws SQLException{}

    ConnectionDB connectionDB = new ConnectionDB();
    Query query = new HospitalQueryImpl();

    public void add() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        PreparedStatement ps = connectionDB.getConn().prepareStatement(query.add());
        ps.setString(1, "1");
        ps.setString(1, "hello");
        ps.setString(1, "13323");

        ps.executeUpdate();
        ps.close();
    }

    public void userSelectOne() throws SQLException {
        PreparedStatement ps = connectionDB.getConn().prepareStatement(query.findOne());
        ps.setInt(1, 1);

        ps.executeUpdate();
        ps.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add();
        userDao.userSelectOne();
    }
}


