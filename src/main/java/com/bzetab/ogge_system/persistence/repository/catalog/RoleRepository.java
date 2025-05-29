package com.bzetab.ogge_system.persistence.repository.catalog;

import com.bzetab.ogge_system.persistence.model.catalog.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
