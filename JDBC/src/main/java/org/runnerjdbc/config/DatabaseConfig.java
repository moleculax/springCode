package org.runnerjdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    public Connection getConnection() throws SQLException {
        final var jdbcUrl = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1";
        final var userDB = "sa";
        final var password = "";
        final var scriptPath = "src/main/resources/schema.sql";
        final var initDB = "RUNSCRIPT FROM '" + scriptPath + "'";

        Connection conn = DriverManager.getConnection(jdbcUrl, userDB, password);

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(initDB);
        }

        return conn;
    }
}
