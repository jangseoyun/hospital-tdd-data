package com.db.mysql;

public interface Query {
    String selectAll();
    String insertQuery(String id, String address, String district, String category, int emergencyRoom, String name, String subdivision);
}
