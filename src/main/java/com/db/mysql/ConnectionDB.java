package com.db.mysql;

import java.sql.*;
import java.util.Map;

public class ConnectionDB {
    private Map<String, String> env = System.getenv();
    private final String dbPw = env.get("DB_PASSWORD");
    private final String dbUser = env.get("DB_USER");
    private final String dbHost = env.get("DB_HOST");

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public ConnectionDB() throws SQLException {
        this.conn = DriverManager.getConnection(dbHost, dbUser, dbPw);
    }

    public Connection getConn() {
        return conn;
    }
}
