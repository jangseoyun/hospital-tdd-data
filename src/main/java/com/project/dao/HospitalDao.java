package com.project.dao;

import com.db.mysql.ConnectionMysqlImpl;
import com.project.query.Query;
import com.project.query.HospitalQueryImpl;

import java.sql.SQLException;

public class HospitalDao {
    ConnectionMysqlImpl connectionDB = new ConnectionMysqlImpl();
    Query query = new HospitalQueryImpl();

    public HospitalDao() throws SQLException {
    }

    public void findOne() {

    }
}

