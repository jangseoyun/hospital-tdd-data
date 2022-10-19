package com.project.dao;

import com.db.mysql.ConnectionLocalImpl;
import com.db.mysql.ConnectionMysqlImpl;

import java.sql.SQLException;

public class UserDaoFactory {
    public UserDao awsUserDao() throws SQLException {
        ConnectionMysqlImpl connectionMysql = new ConnectionMysqlImpl();
        UserDao userDao = new UserDao(connectionMysql);
        return userDao;
    }

    public UserDao localUserDao() throws SQLException {
        ConnectionLocalImpl connectionLocal = new ConnectionLocalImpl();
        UserDao userDao = new UserDao(connectionLocal);
        return userDao;
    }
}
