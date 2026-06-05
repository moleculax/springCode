package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.config.DatabaseH2Config;
import org.example.dto.EmployeeDTO;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DatabaseH2Config dbConfig = new DatabaseH2Config();
        LosDatosH2 losDatos = new LosDatosH2(dbConfig.getDataSource());
        ejecutaScriptSQL ejecutaScriptSQL = new ejecutaScriptSQL();
        ejecutaScriptSQL.execSqlScript(dbConfig.getDataSource());

        List<EmployeeDTO> employees = losDatos.getEmployees();

        for (EmployeeDTO emp : employees) {
            System.out.println(emp.getName() + " - " + emp.getEmail() + " - " + emp.getDepartmentName());
        }

    }



}// END CLASS Main
