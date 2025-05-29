package com.bzetab.ogge_system.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tbl_teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    @Column(nullable = false, unique = true, length = 100)
    private String teacherCode;

    @Column(nullable = false)
    private Boolean isActive;

    //Relation with PersonEntity
    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    @JsonManagedReference("teacher_person") //Reference
    private PersonEntity person;

    //Relation with TeacherSpecialtyEntity
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("teacher_specialty") //Reference
    private Set<TeacherSpecialtyEntity> teacherSpecialties = new HashSet<>();

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

