package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseH2Config {

    // Definimos el DataSource como una variable de la clase
    private final HikariDataSource dataSource;

    public DatabaseH2Config() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.h2.Driver");
        // Mantenemos únicamente la URL que incluye el retraso de cierre obligatorio
        config.setJdbcUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");

        config.setUsername("sa");
        config.setPassword("");

        this.dataSource = new HikariDataSource(config);
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

}// END CLASS
