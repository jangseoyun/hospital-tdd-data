package com.project.query;

import com.db.mysql.Query;

public class HospitalQueryImpl implements Query {
    @Override
    public String findAll() {
        String query = "";
        query += ", id";
        query += ", address";
        query += ", district";
        query += ", category";
        query += ", emergency_room";
        query += ", name";
        query += ", subdivision \n";
        query += "from seoul_hospital";
        System.out.println(query);
        return query;
    }

    @Override
    public String findOne() {
        String query = "";
        query += "select *";
        query += "from users";
        query += "where users.id = ?";
        return query;
    }

    @Override
    public String add() {
        String query = "";
        query += "INSERT INTO `likelion-db`.`seoul_hospital`";
        query += "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)";
        query += "values (?, ?, ?, ?, ?, ?, ?)";
        return query;
    }


}
