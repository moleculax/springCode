package org.runnerjdbc;

import org.runnerjdbc.conexion.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var main = new Main();
        var employees = main.getEmployees();


        // employees.forEach(System.out::println);

        for (var emp : employees) {
            System.out.println(emp.getName()+" / "+emp.getEmail()+" / "+emp.getDepartmentName());
        }
    }

    public List<EmployeeDTO> getEmployees() {
        // CREO CONEXION CON DB
        DatabaseConfig dbConfig = new DatabaseConfig();

        final var query = """
                            SELECT 
                                e.id, e.name,
                                e.email,
                                e.department_id,
                                d.name AS department_name 
                            FROM employees e 
                            JOIN departments d ON(e.department_id = d.id);
                        """;

        try (var conn = dbConfig.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);

            var employees = new ArrayList<EmployeeDTO>();

            while (rs.next()) {
                var employee = new EmployeeDTO();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartmentId(rs.getInt("department_id"));
                employee.setDepartmentName(rs.getString("department_name"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return new ArrayList<>(); //  lista vacía en caso de error
        }
    }
}