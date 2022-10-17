package com.db.mysql;

public interface Query {
    String selectAll();
    String insertQuery();
    String userSelectOne();

    String userInsert();
}
