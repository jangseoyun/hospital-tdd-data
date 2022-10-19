package com.project.dao;

import com.project.vo.UserVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@DisplayName("user DAO 데이터 쿼리 ")
class UserDaoTest {

    @DisplayName("사용자 등록 성공 확인")
    @Test
    void 사용자등록테스트() throws SQLException, ClassNotFoundException {
        //given
        //UserDao userDao = new UserDao(new ConnectionMysqlImpl());
        UserDao userDao = new UserDaoFactory().awsUserDao();
        UserVo user = new UserVo(2, "hellohahaha", "1234");
        userDao.add(user);

        UserVo selectUserOne = userDao.userFindById(1);
        //when
        Assertions.assertEquals("seoyun", selectUserOne.getName());
    }

    @DisplayName("특정 사용자 삭제")
    @Test
    void 특정사용자삭제() throws SQLException {
        UserDao userDao = new UserDaoFactory().awsUserDao();

    }
}