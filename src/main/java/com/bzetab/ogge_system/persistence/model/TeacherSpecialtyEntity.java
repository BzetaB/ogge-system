package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.SpecialtyEntity;
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
@Table(name = "tbl_teacher_specialty")
public class TeacherSpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacherSpecialty;

    //Relation with TeacherEntity
    @ManyToOne
    @JoinColumn(name = "id_teacher", nullable = false)
    @JsonBackReference("teacher_specialty") //Reference
    private TeacherEntity teacher;

    //Relation with SpecialtyEntity
    @ManyToOne
    @JoinColumn(name = "id_specialty", nullable = false)
    @JsonBackReference("specialty_teacher") //Reference
    private SpecialtyEntity specialty;

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
