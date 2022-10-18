package com.project.dao;

import com.project.vo.UserVo;

public class UserFactory {
    public static UserVo createUser(int id, String name, String password) {
        return new UserVo(id, name, password);
    }
}
