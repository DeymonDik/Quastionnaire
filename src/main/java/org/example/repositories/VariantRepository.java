package org.example.repositories;

import org.example.models.entities.VariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<VariantEntity, Long> {
}
