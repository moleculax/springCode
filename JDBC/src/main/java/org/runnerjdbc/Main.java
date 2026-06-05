package org.runnerjdbc;

import org.runnerjdbc.repository.EmpleadosRepository;

public class Main {

    public static void main(String[] args) {
        EmpleadosRepository  empleadosRepository = new EmpleadosRepository();
        var employees = empleadosRepository.getEmployees();
        // employees.forEach(System.out::println);

        for (var emp : employees) {
            System.out.println(emp.getName()+" / "+emp.getEmail()+" / "+emp.getDepartmentName());
        }

    }

}// END CLASS