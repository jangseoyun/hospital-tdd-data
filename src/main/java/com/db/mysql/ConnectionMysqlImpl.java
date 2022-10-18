package com.db.mysql;

import java.sql.*;
import java.util.Map;

public class ConnectionMysqlImpl implements DbConnector{//TODO: db를 설정을 각각 적용해주면 좋겠다
    private Map<String, String> env;
    private Connection conn;

    public ConnectionMysqlImpl() throws SQLException {
        this.env = System.getenv();
        this.conn = DriverManager.getConnection(env.get("DB_HOST"), env.get("DB_USER"), env.get("DB_PASSWORD"));
    }

    @Override
    public Connection dbConnector() {
        return conn;
    }
}
