package com.alexisabel.audsys.auditoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public Optional<Auditoria> getAuditoria(@PathVariable("auditoriaId") Long AuditoriaId) {
        return auditoriaService.getAuditoria(AuditoriaId);
    }

    @PostMapping
    public void addAuditoria(@Validated @RequestBody AuditoriaDTO auditoriaDTO) {
        auditoriaService.addAuditoria(auditoriaDTO);
    }

    @DeleteMapping(path = "{AuditoriaId}")
    public void deleteAuditoria(@PathVariable Long AuditoriaId) {
        auditoriaService.deleteAuditoria(AuditoriaId);
    }
    @PutMapping(path = "{AuditoriaId}")
    public void updateAuditoria(@PathVariable("AuditoriaId") Long auditoriaId,
                                @RequestBody AuditoriaDTO auditoriaDTO) {
        auditoriaService.updateAuditoria(auditoriaId, auditoriaDTO);
    }

}
