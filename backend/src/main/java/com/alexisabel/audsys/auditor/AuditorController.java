package com.alexisabel.audsys.auditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/auditor")
public class AuditorController {
    private final AuditorService auditorService;


    @Autowired
    public AuditorController(AuditorService auditorService) {
        this.auditorService = auditorService;
    }

    @GetMapping()
    public List<Auditor> getAuditors() {
        return auditorService.getAuditors();
    }

    @GetMapping(path = "{auditorId}")
    public Optional<Auditor> getAuditor(@PathVariable("auditorId") Long AuditorId) {
        return auditorService.getAuditor(AuditorId);
    }

    @PostMapping
    public void addAuditor(@RequestBody AuditorDTO auditorDTO) {
        auditorService.addAuditor(auditorDTO);
    }



    @DeleteMapping(path = "{auditorId}")
    public void deleteAuditor(@PathVariable Long auditorId) {
        auditorService.deleteAuditor(auditorId);
    }
    @PutMapping(path = "{auditorId}")
    public void updateAuditor(@PathVariable Long auditorId, @RequestBody AuditorDTO auditorDTO) {
        auditorService.updateAuditor(auditorId, auditorDTO);
    }
}
