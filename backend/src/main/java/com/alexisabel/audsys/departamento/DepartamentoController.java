package com.alexisabel.audsys.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/departamento")
public class DepartamentoController {
    private final DepartamentoService departamentoService;


    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping()
    public List<Departamento> getDepartamentos() {
    return departamentoService.getDepartamentos();
    }

    @GetMapping(path = "{departamentoId}")
    public Optional<Departamento> getDepartamento(@PathVariable("departamentoId") Long departamentoId) {
        return departamentoService.getDepartamento(departamentoId);
    }

    @PostMapping
    public void addDepartamento(@Valid @RequestBody DepartamentoDTO dto) {
        departamentoService.addDepartamento(dto);
    }

    @DeleteMapping(path = "{departamentoId}")
    public void deleteDepartamento(@PathVariable Long departamentoId) {
        departamentoService.deleteDepartamento(departamentoId);
    }
    @PutMapping(path = "{departamentoId}")
    public void updateDepartamento(@PathVariable Long departamentoId,
                                   @Valid @RequestBody DepartamentoDTO dto) {
        departamentoService.updateDepartamento(departamentoId, dto);
    }

}
