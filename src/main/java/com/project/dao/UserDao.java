package com.project.dao;

import com.db.mysql.ConnectionDB;
import com.db.mysql.Query;
import com.project.query.UserQueryImpl;
import com.project.vo.UserVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public UserDao() throws SQLException {
    }

    private PreparedStatement ps = null;

    ConnectionDB connectionDB = new ConnectionDB();
    Query query = new UserQueryImpl();

    public void add() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ps = connectionDB.getConn().prepareStatement(query.add());
        ps.setInt(1, 1);
        ps.setString(2, "hello");
        ps.setString(3, "13323");

    }

    public void userSelectOne() throws SQLException {
        PreparedStatement ps = connectionDB.getConn().prepareStatement(query.findOne());
        ps.setInt(1, 1);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int getId = rs.getInt(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            System.out.println(getId);
        }

        ps.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        //userDao.add();
        userDao.userSelectOne();

    }
}


