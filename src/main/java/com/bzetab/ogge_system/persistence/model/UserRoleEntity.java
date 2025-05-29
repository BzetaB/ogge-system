package com.bzetab.ogge_system.persistence.model;

import com.bzetab.ogge_system.persistence.model.catalog.RoleEntity;
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
@Table(name = "tbl_user_role")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserRole;

    @Column(nullable = false)
    private Boolean isActive;

    //Relation with RoleEntity
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    @JsonBackReference("role_user") //Reference
    private RoleEntity roles;

    //Relation with UserEntity
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonBackReference("user_role") //Reference
    private UserEntity users;

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
