package org.runnerjdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    // CONEXION H2
    public Connection getH2Connection() throws SQLException {
    	

// CONFIGURACIÓN DE BASE DE DATOS H2
// ============================================================
// URL de conexión a la base de datos H2
// jdbc:h2: → protocolo de conexión a H2
// ~/test → ruta donde se guarda el archivo de la base de datos (en el home del usuario)
// DB_CLOSE_DELAY=-1 → mantiene la base de datos abierta incluso si se cierra la última conexión
// Usuario para autenticación en la base de datos
// "sa" = System Administrator (administrador del sistema) - usuario por defecto de H2
// Contraseña del usuario (vacía por defecto en H2)
// En entornos de desarrollo se deja vacía, en producción se debe establecer una segura
// Ruta del archivo SQL que contiene el esquema de la base de datos
// src/main/resources/ → carpeta estándar de recursos en Maven/Gradle
// schema.sql → archivo con sentencias CREATE TABLE, INSERT, etc.
// Comando SQL para ejecutar un script externo
// RUNSCRIPT FROM → comando de H2 que ejecuta todas las sentencias SQL de un archivo
// ' + scriptPath + ' → concatena la ruta del archivo al comando
// El resultado final será: RUNSCRIPT FROM 'src/main/resources/schema.sql'


        final var jdbcUrl = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1";
        final var userDB = "sa";
        final var password = "";
        final var scriptPath = "src/main/resources/schema.sql";
        final var initDB = "RUNSCRIPT FROM '" + scriptPath + "'";
        // ============================================================
        
        Connection conn = DriverManager.getConnection(jdbcUrl, userDB, password);
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(initDB);
        }
        return conn;
    }


    // CONEXION MariaDB
    public Connection getMariaDbConnection() throws SQLException {
        final var jdbcUrl = "jdbc:mariadb://localhost:3306/neurocode";
        final var userDB = "admin";
        final var password = "admin123";

        Connection conn = DriverManager.getConnection(jdbcUrl, userDB, password);
        return conn;
    }

    // CONEXION  PostgreSQL
    public Connection getPostgresConnection() throws SQLException {
        final var jdbcUrl = "jdbc:postgresql://localhost:5432/neurocode";
        final var userDB = "admin";
        final var password = "admin123";

        Connection conn = DriverManager.getConnection(jdbcUrl, userDB, password);
        return conn;
    }



}
