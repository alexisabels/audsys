package com.alexisabel.audsys.planAccion;

import com.alexisabel.audsys.auditoria.Auditoria;
import com.alexisabel.audsys.auditoria.AuditoriaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlanAccionService {

    private final PlanAccionRepository planAccionRepository;
    private final AuditoriaRepository auditoriaRepository;

    @Autowired
    public PlanAccionService(PlanAccionRepository planAccionRepository, AuditoriaRepository auditoriaRepository) {
        this.planAccionRepository = planAccionRepository;
        this.auditoriaRepository = auditoriaRepository;
    }

    public List<PlanAccion> getPlanes() {
        return planAccionRepository.findAll();
    }

    public Optional<PlanAccion> getPlanAccion(Long planId) {
        return planAccionRepository.findById(planId);
    }

    public void addPlanAccion(PlanAccionDTO dto) {
        Auditoria auditoria = auditoriaRepository.findById(dto.getAuditoriaId()).orElseThrow(() -> new IllegalStateException("Auditoría con ID " + dto.getAuditoriaId() + " no encontrada"));

        PlanAccion plan = new PlanAccion(dto.getDescripcion(), dto.getEstado(), auditoria);

        planAccionRepository.save(plan);
    }

    public void deletePlan(Long planId) {
        boolean exists = planAccionRepository.existsById(planId);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Plan de acción con el id " + planId + " no existe");
        }
        planAccionRepository.deleteById(planId);
    }

    @Transactional
    public void updatePlanAccion(Long planId, PlanAccionDTO dto) {
        PlanAccion planAccion = planAccionRepository.findById(planId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Plan de acción con el ID " + planId + " no existe"));

        if (dto.getDescripcion() != null && !dto.getDescripcion().isEmpty()) {
            planAccion.setDescripcion(dto.getDescripcion());
        }

        if (dto.getEstado() != null) {
            planAccion.setEstado(dto.getEstado());
        }

        if (dto.getAuditoriaId() != null) {
            Auditoria auditoria = auditoriaRepository.findById(dto.getAuditoriaId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Auditoría con ID " + dto.getAuditoriaId() + " no encontrada"));
            planAccion.setAuditoria(auditoria);
        }

        planAccionRepository.save(planAccion);
    }

}
