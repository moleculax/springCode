package org.hibern.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "departments")
@Builder
@NoArgsConstructor // Genera un constructor sin argumentos (vacío).
@AllArgsConstructor //Genera un constructor con todos los argumentos (uno por cada campo).

public class DepartamentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;

}
