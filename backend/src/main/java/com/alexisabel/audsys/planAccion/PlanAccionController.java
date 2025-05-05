package com.alexisabel.audsys.planAccion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@Tag(name = "Planes de Acción", description = "Planes definidos para corregir o mejorar aspectos detectados en las auditorías.")
@RestController
@RequestMapping(path = "/api/v1/planAccion")
public class PlanAccionController {

    private final PlanAccionService planAccionService;

    @Autowired
    public PlanAccionController(PlanAccionService planAccionService) {
        this.planAccionService = planAccionService;
    }

    @GetMapping()
    public List<PlanAccion> getPlanes() {
        return planAccionService.getPlanes();
    }

    @GetMapping(path = "{planId}")
    public Optional<PlanAccion> getPlanAccion(@PathVariable("planId") Long planId) {
        return planAccionService.getPlanAccion(planId);
    }

    @PostMapping
    public void addPlanAccion(@Valid @RequestBody PlanAccionDTO planAccionDTO) {
        planAccionService.addPlanAccion(planAccionDTO);
    }

    @DeleteMapping(path = "{planId}")
    public void deletePlan(@PathVariable Long planId) {
        planAccionService.deletePlan(planId);
    }

    @PutMapping(path = "{planId}")
    public void updatePlanAccion(@PathVariable("planId") Long planId,
                                 @Valid @RequestBody PlanAccionDTO planAccionDTO) {
        planAccionService.updatePlanAccion(planId, planAccionDTO);
    }
}
