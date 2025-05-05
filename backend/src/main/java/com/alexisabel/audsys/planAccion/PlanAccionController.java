package com.alexisabel.audsys.planAccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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
    public void addPlanAccion(@Validated @RequestBody PlanAccionDTO planAccionDTO) {
        planAccionService.addPlanAccion(planAccionDTO);
    }

    @DeleteMapping(path = "{planId}")
    public void deletePlan(@PathVariable Long planId) {
        planAccionService.deletePlan(planId);
    }

    @PutMapping(path = "{planId}")
    public void updatePlanAccion(@PathVariable("planId") Long planId,
                                  @RequestBody PlanAccionDTO planAccionDTO) {
        planAccionService.updatePlanAccion(planId, planAccionDTO);
    }
}
