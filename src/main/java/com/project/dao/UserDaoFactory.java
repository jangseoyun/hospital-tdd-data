package com.project.dao;

import com.db.mysql.ConnectionLocalImpl;
import com.db.mysql.ConnectionMysqlImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class UserDaoFactory {
    @Bean
    public UserDao awsUserDao() throws SQLException {
        ConnectionMysqlImpl connectionMysql = new ConnectionMysqlImpl();
        // context 재사용 하는 부분이 많은 코드(add, select....)
        UserDao userDao = new UserDao(connectionMysql);
        return userDao;
    }

    @Bean
    public UserDao localUserDao() throws SQLException {
        ConnectionLocalImpl connectionLocal = new ConnectionLocalImpl();
        UserDao userDao = new UserDao(connectionLocal);
        return userDao;
    }
}
