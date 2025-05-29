package com.bzetab.ogge_system.persistence.repository.catalog;

import com.bzetab.ogge_system.persistence.model.catalog.StepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<StepEntity, Long> {
}
