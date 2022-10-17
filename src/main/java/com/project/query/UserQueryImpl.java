package com.project.query;

import com.db.mysql.Query;

public class UserQueryImpl implements Query {
    @Override
    public String findOne() {
        String query = "";
        query += "select *";
        query += "from users";
        query += "where users.id = ?";
        System.out.println(query);
        return query;
    }

    @Override
    public String add() {
        String query = "";
        query += "insert into users(id, name, password) values (?, ?, ?)";
        return query;
    }

    @Override
    public String findAll() {
        String query = "";
        query += "select *";
        query += "from users";
        return query;
    }
}
