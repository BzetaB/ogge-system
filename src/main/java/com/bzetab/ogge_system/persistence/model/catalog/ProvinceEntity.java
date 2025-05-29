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
@Table(name = "tbl_province")
public class ProvinceEntity {
    @Id
    @Column(nullable = false, length = 4)
    private String idProvince;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    //Relation with DepartmentEntity
    @ManyToOne
    @JoinColumn(name = "id_department", nullable = false, unique = true)
    private DepartmentEntity department;

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
