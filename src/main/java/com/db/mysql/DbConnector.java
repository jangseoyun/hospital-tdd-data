package com.db.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnector {
    Connection dbConnector() throws SQLException;//TODO: db를 넘겨주면 구현체에서 설정을 각각 할 수 있으면 좋겠다
}
