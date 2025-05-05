package com.alexisabel.course.auditor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuditorRepository extends JpaRepository<Auditor, Long> {

}
