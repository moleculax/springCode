package org.hibern.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.C;

@Data
@Entity
@Table(name = "employees")
@Builder
@NoArgsConstructor // Genera un constructor sin argumentos (vacío).
@AllArgsConstructor //Genera un constructor con todos los argumentos (uno por cada campo).
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "departament_id", nullable = false)
    private DepartamentEntity department;

}// END ENTITY
