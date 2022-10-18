package com.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLocalImpl implements DbConnector{

    @Override
    public Connection dbConnector() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "",
                "",
                ""
        );

        return conn;
    }
}
