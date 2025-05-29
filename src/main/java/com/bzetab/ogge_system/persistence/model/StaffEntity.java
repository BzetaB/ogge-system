package com.bzetab.ogge_system.persistence.model;

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
@Table(name = "tbl_staff")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStaff;

    @Column(nullable = false)
    private LocalDate dateAdmission;

    @Column(nullable = false)
    private LocalDate dateDeparture;

    @Column(nullable = false)
    private Boolean isActive;

    //Relation with PersonEntity
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    @JsonManagedReference("staff_person")
    private PersonEntity person;

    //Relation with StaffStepEntity
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("staff_step") //Reference
    private Set<StaffStepEntity> staffSteps;

    //Relation with StaffAreaEntity
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("staff_area") //Reference
    private Set<StaffAreaEntity> staffAreas;

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
