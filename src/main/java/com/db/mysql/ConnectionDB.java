package com.db.mysql;

import java.sql.*;
import java.util.Map;

public class ConnectionDB {
    private Map<String, String> env;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ConnectionDB() throws SQLException {
        this.env = System.getenv();
        this.conn = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
        this.ps = null;
        this.rs = null;
    }

    public Connection getConn() {
        return conn;
    }

    public static void main(String[] args) {

    }

}
