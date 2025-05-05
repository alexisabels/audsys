package com.alexisabel.audsys.observacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/observacion")
public class ObservacionController {

    private final ObservacionService observacionService;

    @Autowired
    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @GetMapping()
    public List<Observacion> getObservaciones() {
        return observacionService.getObservaciones();
    }

    @GetMapping(path = "{observacionId}")
    public Optional<Observacion> getObservacion(@PathVariable("observacionId") Long observacionId) {
        return observacionService.getObservacion(observacionId);
    }

    @PostMapping
    public void addObservacion(@Validated @RequestBody ObservacionDTO observacionDTO) {
        observacionService.addObservacion(observacionDTO);
    }

    @DeleteMapping(path = "{observacionId}")
    public void deleteObservacion(@PathVariable Long observacionId) {
        observacionService.deleteObservacion(observacionId);
    }

    @PutMapping(path = "{observacionId}")
    public void updateObservacion(@PathVariable("observacionId") Long observacionId,
                                  @RequestBody ObservacionDTO observacionDTO) {
        observacionService.updateObservacion(observacionId, observacionDTO);
    }
}
