package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.DegreeEntity;
import com.bzetab.ogge_system.persistence.model.catalog.StatusDegreeEntity;
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
@Table(name = "tbl_person_degree")
public class PersonDegreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonDegree;

    @Column(nullable = false, length = 200)
    private String nameDegree;

    @Column(nullable = false)
    private Boolean isCurrent;

    @Column(nullable = false)
    private LocalDate dateAdmission;

    @Column(nullable = false)
    private LocalDate dateGraduation;

    //Relation with StatusDegreeEntity
    @ManyToOne
    @JoinColumn(name = "id_status_degree", nullable = false)
    private StatusDegreeEntity statusDegree;

    //Relation with DegreeEntity
    @ManyToOne()
    @JoinColumn(name = "id_degree", nullable = false)
    @JsonBackReference("degree_person") //Reference
    private DegreeEntity degree;

    //Relation with PersonEntity
    @ManyToOne()
    @JoinColumn(name = "id_person", nullable = false)
    @JsonBackReference("person_degree") //Reference
    private PersonEntity person;

    //Log
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private Long createdBy; //idUser

    private Long updatedBy; //idUser
}
