package com.alexisabel.course.auditor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditorService {

    private final AuditorRepository auditorRepository;
    @Autowired
    public AuditorService(AuditorRepository AuditorRepository) {
        this.auditorRepository = AuditorRepository;
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
        if(!exists) {
            throw new IllegalStateException("El Auditor con el id "+auditorId+" does not exist");
        }
        auditorRepository.deleteById(auditorId);
    }
    @Transactional
    public void updateAuditor(Long auditorId, AuditorDTO dto) {
        Auditor auditor = auditorRepository.findById(auditorId)
                .orElseThrow(() -> new IllegalStateException("No existe el auditor con id: " + auditorId));

        if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
            auditor.setNombre(dto.getNombre());
        }
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            auditor.setEmail(dto.getEmail());
        }
    }
}
