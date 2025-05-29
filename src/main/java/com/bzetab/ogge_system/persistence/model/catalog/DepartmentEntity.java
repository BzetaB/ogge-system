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
@Table(name = "tbl_department")
public class DepartmentEntity {
    @Id
    @Column(nullable = false, length = 2)
    private String idDepartment;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

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
