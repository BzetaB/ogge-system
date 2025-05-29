package com.bzetab.ogge_system.persistence.repository;

import com.bzetab.ogge_system.persistence.model.PersonDegreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDegreeRepository extends JpaRepository<PersonDegreeEntity, Long> {
}
