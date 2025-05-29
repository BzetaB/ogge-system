package com.bzetab.ogge_system.persistence.model.catalog;

import com.bzetab.ogge_system.persistence.model.TeacherSpecialtyEntity;
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
@Table(name = "tbl_specialty")
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecialty;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    //Relation with AreaEntity
    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private AreaEntity area;

    //Relation with TeacherSpecialtyEntity
    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference("specialty_teacher") //Reference
    private Set<TeacherSpecialtyEntity> SpecialtiesTeacher = new HashSet<>();

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
