package com.alexisabel.audsys.observacion;

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
public class ObservacionService {

    private final ObservacionRepository observacionRepository;
    private final AuditoriaRepository auditoriaRepository;

    @Autowired
    public ObservacionService(ObservacionRepository observacionRepository, AuditoriaRepository auditoriaRepository) {
        this.observacionRepository = observacionRepository;
        this.auditoriaRepository = auditoriaRepository;
    }

    public List<Observacion> getObservaciones() {
        return observacionRepository.findAll();
    }

    public Optional<Observacion> getObservacion(Long observacionId) {
        return observacionRepository.findById(observacionId);
    }

    public void addObservacion(ObservacionDTO dto) {
        Auditoria auditoria = auditoriaRepository.findById(dto.getAuditoriaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La auditoría con id: " + dto.getAuditoriaId() + " no existe."));
        Observacion observacion = new Observacion(dto.getDescripcion(), dto.getCriticidad(), auditoria);
        observacionRepository.save(observacion);
    }


    @Transactional
    public void updateObservacion(Long observacionId, ObservacionDTO dto) {
        Observacion observacion = observacionRepository.findById(observacionId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La observación con id: " + observacionId + " no existe."));

        if (dto.getDescripcion() != null && !dto.getDescripcion().equals(observacion.getDescripcion())) {
            observacion.setDescripcion(dto.getDescripcion());
        }

        if (dto.getCriticidad() != null && !dto.getCriticidad().equals(observacion.getCriticidad())) {
            observacion.setCriticidad(dto.getCriticidad());
        }

        if (dto.getAuditoriaId() != null) {
            Auditoria auditoria = auditoriaRepository.findById(dto.getAuditoriaId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "La auditoría con id: " + dto.getAuditoriaId() + " no existe."));
            observacion.setAuditoria(auditoria);
        }
    }

    public void deleteObservacion(Long observacionId) {
        boolean exists = observacionRepository.existsById(observacionId);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La observacion con el id " + observacionId + " no existe");
        }
        observacionRepository.deleteById(observacionId);
    }
}
