package org.hikaricode;

import com.zaxxer.hikari.HikariDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ejecutaScriptSQL {

    // 1. Cambiado a PUBLIC y removido el 'static' para que funcione con tu "new" en el Main
    public void execSqlScript(HikariDataSource ds) {

        final var path = "src/main/resources/schema.sql";

        // 2. Añadimos un bloque try-catch interno para capturar los errores limpiamente
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement();
             FileInputStream fis = new FileInputStream(path);
             Scanner scanner = new Scanner(fis, StandardCharsets.UTF_8)) {

        // 3. Usamos el punto y coma como delimitador para separar cada comando SQL
            scanner.useDelimiter(";");

            System.out.println("Leyendo y ejecutando esquema SQL...");
            while (scanner.hasNext()) {
                String sqlContenido = scanner.next().trim();

        // Evitamos ejecutar líneas en blanco o vacías en el archivo
                if (!sqlContenido.isEmpty()) {
                    statement.execute(sqlContenido);
                }
            }
            System.out.println("¡Script SQL ejecutado con éxito!");

        } catch (FileNotFoundException e) {
            System.err.println("❌ No se encontró el archivo schema.sql en: " + path);
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.err.println("❌ Error de sintaxis SQL al ejecutar el script: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


} // END CLASS
