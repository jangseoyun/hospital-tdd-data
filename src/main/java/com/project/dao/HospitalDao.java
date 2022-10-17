package com.project.dao;

import com.db.mysql.ConnectionDB;
import com.db.mysql.Query;
import com.project.query.HospitalQueryImpl;

import java.sql.SQLException;

public class HospitalDao {
    ConnectionDB connectionDB = new ConnectionDB();
    Query query = new HospitalQueryImpl();

    public HospitalDao() throws SQLException {
    }

    public void findOne() {

    }
}

