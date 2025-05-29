package com.bzetab.ogge_system.persistence.model.catalog;

import com.bzetab.ogge_system.persistence.model.StaffStepEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbl_step")
public class StepEntity {
    //Table to save the names of the steps in a procedure
    //Tabla para guardar los nombres de los pasos de un trámite
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStep;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    //Relation with StaffStepEntity
    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("step_staff") //Reference
    private Set<StaffStepEntity> stepsStaff;

    //Log
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(nullable = false)
    private Long createdBy; //idUser

    private Long updatedBy; //idUser
}
