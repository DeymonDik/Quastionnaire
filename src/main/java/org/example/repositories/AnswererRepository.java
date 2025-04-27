package org.example.repositories;

import org.example.models.entities.AnswererEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswererRepository extends JpaRepository<AnswererEntity, Long> {
}
