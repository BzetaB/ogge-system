package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.DistrictEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tbl_person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;

    @Column(nullable = false, length = 200)
    private String names;

    @Column(nullable = false, length = 200)
    private String motherSurname;

    @Column(nullable = false, length = 200)
    private String fatherSurname;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false, unique = true, length = 100)
    private String institutionalEmail;

    @Column(nullable = false, unique = true, length = 100)
    private String email1;

    @Column(unique = true, length = 100)
    private String email2;

    @Column(nullable = false, unique = true, length = 9)
    private String cellphone1;

    @Column(unique = true, length = 9)
    private String cellphone2;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 200)
    private String address;

    //Relation with UserEntity
    @OneToOne
    @JoinColumn(name = "id_user",nullable = false)
    @JsonManagedReference("person_user") //Reference
    private UserEntity user;

    //Relations with DistrictEntity(Location)
    @ManyToOne
    @JoinColumn(name = "id_district", nullable = false)
    private DistrictEntity district;

    //Relation with PersonDegree
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("person_degree") //Reference
    private Set<PersonDegreeEntity> personDegrees = new HashSet<>();

    //Relation with StudentEntity
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("student_person") //Reference
    private StudentEntity student;

    //Relation with TeacherEntity
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("teacher_person")
    private TeacherEntity teacher;

    //Relation with StaffEntity
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("staff_person")
    private StaffEntity staff;

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
