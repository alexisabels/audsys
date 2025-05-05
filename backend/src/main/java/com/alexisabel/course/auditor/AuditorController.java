package com.alexisabel.course.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/auditor")
public class AuditorController {
    private final AuditorService AuditorService;


    @Autowired
    public AuditorController(AuditorService AuditorService) {
        this.AuditorService = AuditorService;
    }

    @GetMapping()
    public List<Auditor> getAuditors() {
        return AuditorService.getAuditors();
    }

    @GetMapping(path = "{auditorId}")
    public Optional<Auditor> getAuditor(@PathVariable("auditorId") Long AuditorId) {
        return AuditorService.getAuditor(AuditorId);
    }

    @PostMapping
    public void addAuditor(@RequestBody Auditor Auditor) {
        AuditorService.addAuditor(Auditor);
    }
    @DeleteMapping(path = "{AuditorId}")
    public void deleteAuditor(@PathVariable Long AuditorId) {
        AuditorService.deleteAuditor(AuditorId);
    }
    @PutMapping(path = "{AuditorId}")
    public void updateAuditor(@PathVariable("AuditorId") Long AuditorId,
                                   @RequestParam(required = false) String nombre,
                                   @RequestParam(required = false) String responsable) {
        AuditorService.updateAuditor(AuditorId, nombre, responsable);
    }
}
