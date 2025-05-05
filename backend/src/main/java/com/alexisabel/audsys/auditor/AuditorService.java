package com.alexisabel.audsys.auditor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuditorService {

    private final AuditorRepository auditorRepository;
    @Autowired
    public AuditorService(AuditorRepository auditorRepository) {
        this.auditorRepository = auditorRepository;
    }

    public List<Auditor> getAuditors() {
        return auditorRepository.findAll();
    }

    public Optional<Auditor> getAuditor(Long auditorId) {
        return auditorRepository.findById(auditorId);
    }

    public void addAuditor(AuditorDTO dto) {
        Auditor auditor = new Auditor(dto.getNombre(), dto.getEmail());
        auditorRepository.save(auditor);
    }

    public void deleteAuditor(Long auditorId) {
        boolean exists = auditorRepository.existsById(auditorId);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El Auditor con el id " + auditorId + " no existe");
        }
        auditorRepository.deleteById(auditorId);
    }
    @Transactional
    public void updateAuditor(Long auditorId, AuditorDTO dto) {
        Auditor auditor = auditorRepository.findById(auditorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el auditor con id: " + auditorId));

        if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
            auditor.setNombre(dto.getNombre());
        }
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            auditor.setEmail(dto.getEmail());
        }
    }
}
