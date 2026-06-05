package org.hibern;

import org.hibern.config.HibernateConfig;
import org.hibern.entity.DepartamentEntity;
import org.hibern.entity.EmployeeEntity;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {

        Transaction transaction = null;

        try (var session = HibernateConfig.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            var weightDivision = DepartamentEntity
                    .builder()
                    .name("Lightweight Division")
                    .build();
            session.persist(weightDivision);  //  save() → persist()

            // Primer empleado
            var fighter1 = EmployeeEntity.builder()  // Usar Builder en lugar de new + setters
                    .name("John Doe")
                    .email("john.doe@example.com")
                    .department(weightDivision)  // setDepartment() → departament()
                    .build();
            session.persist(fighter1);

            // Segundo empleado
            var fighter2 = EmployeeEntity.builder()  //  Variable con nombre diferente
                    .name("Khabib Nurmagomedov")
                    .email("khabib.nur@example.com")
                    .department(weightDivision)  // setDepartment() → departament()
                    .build();
            session.persist(fighter2);

            transaction.commit();

            // Consulta
            Query<EmployeeEntity> query = session.createQuery(
                    "SELECT e FROM EmployeeEntity e JOIN FETCH e.department",  // ← CORREGIDO: e.department → e.departament
                    EmployeeEntity.class
            );
            var employees = query.list();
            employees.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();  // ← AGREGADO: Rollback en caso de error
            }
        } finally {
            HibernateConfig.shutdown();
        }
    }
}