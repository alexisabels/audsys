package com.alexisabel.audsys.planAccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanAccionRepository extends JpaRepository<PlanAccion, Long> {
}
