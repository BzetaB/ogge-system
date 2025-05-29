package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.StepEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbl_staff_step")
public class StaffStepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStaffStep;

    @Column(nullable = false)
    private Boolean isActive;

    //Relation with StaffEntity
    @ManyToOne
    @JoinColumn(name = "id_staff", nullable = false)
    @JsonBackReference("staff_step") //Reference
    private StaffEntity staff;

    //Relation with StepEntity
    @ManyToOne
    @JoinColumn(name = "id_step", nullable = false)
    @JsonBackReference("step_staff") //Reference
    private StepEntity step;

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
