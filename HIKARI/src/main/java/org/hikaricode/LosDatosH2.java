package org.hikaricode;

import com.zaxxer.hikari.HikariDataSource;
import org.hikaricode.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LosDatosH2 {

    // Recibimos el pool único de la aplicación
    private final HikariDataSource dataSource;

    // Constructor que inyecta la configuración existente
    public LosDatosH2(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<EmployeeDTO> getEmployees() {
        // Inicializamos la lista local que vamos a retornar
        List<EmployeeDTO> employees = new ArrayList<>();

        String sql = "SELECT e.id, e.name, e.email, e.department_id, d.name AS department_name " +
                "FROM employees e " +
                "JOIN departments d ON e.department_id = d.id";

        // IMPORTANTE: Abrimos la Conexión, el Statement y el ResultSet de forma ordenada y segura
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                EmployeeDTO employee = new EmployeeDTO();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setDepartmentName(rs.getString("department_name"));

                employees.add(employee);
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar empleados: " + e.getMessage());
            e.printStackTrace();
        }

        return employees;
    }
} // END CLASS
