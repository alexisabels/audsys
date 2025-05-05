package com.alexisabel.audsys.auditoria;

import com.alexisabel.audsys.auditor.Auditor;
import com.alexisabel.audsys.auditor.AuditorRepository;
import com.alexisabel.audsys.departamento.Departamento;
import com.alexisabel.audsys.departamento.DepartamentoRepository;
import com.alexisabel.audsys.observacion.Observacion;
import com.alexisabel.audsys.observacion.ObservacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class AuditoriaService {

    private final AuditoriaRepository auditoriaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final AuditorRepository auditorRepository;

    @Autowired
    public AuditoriaService(AuditoriaRepository auditoriaRepository, DepartamentoRepository departamentoRepository,
                            AuditorRepository auditorRepository) {
        this.auditoriaRepository = auditoriaRepository;
        this.departamentoRepository = departamentoRepository;
        this.auditorRepository = auditorRepository;
    }

    public List<Auditoria> getAuditorias() {
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> getAuditoria(Long auditoriaId) {
        return auditoriaRepository.findById(auditoriaId);
    }

    @Transactional
    public void addAuditoria(AuditoriaDTO dto) {
        Departamento departamento = departamentoRepository.findById(dto.getDepartamentoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El departamento con id: " + dto.getDepartamentoId() + " no existe."));

        Auditor auditor = auditorRepository.findById(dto.getAuditorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El auditor con id: " + dto.getAuditorId() + " no existe."));

        Auditoria auditoria = new Auditoria(dto.getFecha(), dto.getTipo(), dto.getCategorias(), departamento, auditor);

        if (dto.getObservaciones() != null && !dto.getObservaciones().isEmpty()) {
            List<Observacion> observaciones = new ArrayList<>();
            for (ObservacionDTO observacionDTO : dto.getObservaciones()) {
                Observacion observacion = new Observacion(observacionDTO.getDescripcion(), observacionDTO.getCriticidad(), auditoria);
                observaciones.add(observacion);
            }
            auditoria.setObservaciones(observaciones);

        }

        auditoriaRepository.save(auditoria);
    }

    public void deleteAuditoria(Long auditoriaId) {
        boolean exists = auditoriaRepository.existsById(auditoriaId);
        if(!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La auditoría con el id " + auditoriaId + " no existe");
        }
        auditoriaRepository.deleteById(auditoriaId);
    }

    @Transactional
    public void updateAuditoria(Long auditoriaId, AuditoriaDTO dto) {
        Auditoria auditoria = auditoriaRepository.findById(auditoriaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La auditoría con id: " + auditoriaId + " no existe."));

        if (dto.getFecha() != null && !dto.getFecha().equals(auditoria.getFecha())) {
            auditoria.setFecha(dto.getFecha());
        }

        if (dto.getTipo() != null && !dto.getTipo().equals(auditoria.getTipo())) {
            auditoria.setTipo(dto.getTipo());
        }

        if (dto.getCategorias() != null && !dto.getCategorias().equals(auditoria.getCategorias())) {
            auditoria.setCategorias(dto.getCategorias());
        }

        if (dto.getDepartamentoId() != null) {
            Departamento departamento = departamentoRepository.findById(dto.getDepartamentoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El departamento con id: " + dto.getDepartamentoId() + " no existe."));
            auditoria.setDepartamento(departamento);
        }

        if (dto.getAuditorId() != null) {
            Auditor auditor = auditorRepository.findById(dto.getAuditorId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El auditor con id: " + dto.getAuditorId() + " no existe."));
            auditoria.setAuditor(auditor);
        }
    }
}
