package com.db.mysql;

import java.sql.*;
import java.util.Map;

public class ConnectionDB {
    private Map<String, String> env = System.getenv();
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public ConnectionDB() throws SQLException {
        this.conn = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }

    public Connection getConn() {
        return conn;
    }

    public static void main(String[] args) {
        
    }

}
