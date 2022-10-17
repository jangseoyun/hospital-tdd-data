package com.db.mysql;

public class QueryImpl implements Query {
    @Override
    public String selectAll() {
        String query = "";
        query += "select id";
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
    public String insertQuery(String id, String address, String district, String category, int emergencyRoom, String name, String subdivision) {

        String query = "";
        query += "INSERT INTO `likelion-db`.`seoul_hospital`";
        query += "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)";
        query += "( "
                    + id
                    + address
                    + district
                    + category
                    + emergencyRoom
                    + name
                    + subdivision
                    + ")";
        return query;
    }

    @Override
    public String userSelectOne() {
        String query = "";
        query += "select *";
        query += "from users";
        query += "where users.id = 1";
        System.out.println(query);
        return query;
    }


}
