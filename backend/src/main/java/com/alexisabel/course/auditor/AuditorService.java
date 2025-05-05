package com.alexisabel.course.auditor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuditorService {

    private final AuditorRepository AuditorRepository;
    @Autowired
    public AuditorService(AuditorRepository AuditorRepository) {
        this.AuditorRepository = AuditorRepository;
    }

    public List<Auditor> getAuditors() {
        return AuditorRepository.findAll();
    }

    public Optional<Auditor> getAuditor(Long AuditorId) {
        return AuditorRepository.findById(AuditorId);
    }

    public void addAuditor(Auditor Auditor) {
        AuditorRepository.save(Auditor);
    }

    public void deleteAuditor(Long AuditorId) {
        boolean exists = AuditorRepository.existsById(AuditorId);
        if(!exists) {
            throw new IllegalStateException("El Auditor con el id "+AuditorId+" does not exist");
        }
        AuditorRepository.deleteById(AuditorId);
    }
    @Transactional
    public void updateAuditor(Long AuditorId, String nombre, String email) {
        Auditor Auditor = AuditorRepository.findById(AuditorId).orElseThrow(() -> new IllegalStateException("El Auditor con id: "+AuditorId+" no existe."));
        if(nombre != null && !nombre.isEmpty() && !Objects.equals(Auditor.getNombre(), nombre))
        {
            Auditor.setNombre(nombre);
        }
        if(email != null && !email.isEmpty() && !Objects.equals(Auditor.getEmail(), email))
        {
            Auditor.setEmail(email);
        }
    }
}
