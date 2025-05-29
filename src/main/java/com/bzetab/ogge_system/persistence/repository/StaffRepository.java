package com.bzetab.ogge_system.persistence.repository;

import com.bzetab.ogge_system.persistence.model.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
