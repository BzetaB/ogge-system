package com.bzetab.ogge_system.persistence.model.catalog;

import com.bzetab.ogge_system.persistence.model.PersonDegreeEntity;
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
@Table(name = "tbl_degree")
public class DegreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDegree;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    //Relation with PersonDegreeEntity
    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("degree_person") //Reference
    private Set<PersonDegreeEntity> degreesPerson = new HashSet<>();

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
