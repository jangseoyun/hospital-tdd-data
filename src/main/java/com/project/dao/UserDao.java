package com.project.dao;

import com.db.mysql.ConnectionMysqlImpl;
import com.db.mysql.DbConnector;
import com.project.query.Query;
import com.project.query.UserQueryImpl;
import com.project.vo.UserVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private DbConnector toMysql;
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

    public void deleteById(int id) {
        int result = 0;
        try {
            PreparedStatement ps = toMysql.dbConnector().prepareStatement(query.deleteOne());
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);// 성공하면 1, 실패하면 0
    }

    public int getCountAll() {
        int count = 0;
        try {
            PreparedStatement ps = toMysql.dbConnector().prepareStatement(query.getCountAll());
            ResultSet rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        //userDao.add(new UserVo(1, "seoyun", "1234"));
        //userDao.userFindById(1);
        //userDao.deleteById(2);
        int countAll = userDao.getCountAll();
        System.out.println(countAll);
    }
}


