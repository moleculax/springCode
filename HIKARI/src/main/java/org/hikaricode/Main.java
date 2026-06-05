package org.hikaricode;

import org.hikaricode.config.DatabaseH2Config;
import org.hikaricode.dto.EmployeeDTO;

import java.util.List;


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
