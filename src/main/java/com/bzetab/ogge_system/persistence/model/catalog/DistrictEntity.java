package com.bzetab.ogge_system.persistence.model.catalog;

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
@Table(name = "tbl_district")
public class DistrictEntity {
    @Id
    @Column(nullable = false, length = 6)
    private String idDistrict;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    //Relation with ProvinceEntity
    @ManyToOne
    @JoinColumn(name = "id_province", nullable = false)
    private ProvinceEntity province;

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
