package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.AreaEntity;
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
@Table(name = "tbl_staff_area")
public class StaffAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStaffArea;

    @Column(nullable = false)
    private Boolean isActive;

    //Relation with StaffEntity
    @ManyToOne
    @JoinColumn(name = "id_staff", nullable = false)
    @JsonBackReference("staff_area") //Reference
    private StaffEntity staff;

    //Relation with AreaEntity
    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    @JsonBackReference("area_staff") //Reference
    private AreaEntity area;

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
