package com.alexisabel.audsys.auditoria;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/auditoria")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    @Autowired
    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @GetMapping()
    public List<Auditoria> getAuditorias() {
        return auditoriaService.getAuditorias();
    }

    @GetMapping(path = "{auditoriaId}")
    public Optional<Auditoria> getAuditoria(@PathVariable("auditoriaId") Long auditoriaId) {
        return auditoriaService.getAuditoria(auditoriaId);
    }

    @PostMapping
    public void addAuditoria(@Valid @RequestBody AuditoriaDTO auditoriaDTO) {
        auditoriaService.addAuditoria(auditoriaDTO);
    }

    @DeleteMapping(path = "{auditoriaId}")
    public void deleteAuditoria(@PathVariable Long auditoriaId) {
        auditoriaService.deleteAuditoria(auditoriaId);
    }

    @PutMapping(path = "{auditoriaId}")
    public void updateAuditoria(@PathVariable("auditoriaId") Long auditoriaId,
                                @Valid @RequestBody AuditoriaDTO auditoriaDTO) {
        auditoriaService.updateAuditoria(auditoriaId, auditoriaDTO);
    }
}
