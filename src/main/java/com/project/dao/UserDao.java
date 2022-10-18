package com.project.dao;

import com.db.mysql.ConnectionMysqlImpl;
import com.project.query.Query;
import com.project.query.UserQueryImpl;
import com.project.vo.UserVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMysqlImpl toMysql;
    private PreparedStatement ps;
    private Query query;

    public UserDao() throws SQLException {
        this.toMysql = new ConnectionMysqlImpl();
        this.query = new UserQueryImpl();
        this.ps = null;
    }

    public void add(UserVo user) {
        try {
            ps = toMysql.dbConnector().prepareStatement(query.add());
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserVo userFindById(int id) throws SQLException {
        PreparedStatement ps = toMysql.dbConnector().prepareStatement(query.findOne());
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        UserVo user = null;
        while (rs.next()) {
            int getId = rs.getInt(1);
            String getName = rs.getString(2);
            String getPassword = rs.getString(3);
            user = new UserVo(getId, getName, getPassword);
        }
        rs.close();
        ps.close();
        return user;

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        userDao.add(new UserVo(1, "seoyun", "1234"));
        //userDao.userFindById(1);
    }
}


