package com.alexisabel.course.auditoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

}
