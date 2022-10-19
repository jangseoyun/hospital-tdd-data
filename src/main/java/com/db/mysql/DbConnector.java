package com.db.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
    Connection dbConnector() throws SQLException;
}
