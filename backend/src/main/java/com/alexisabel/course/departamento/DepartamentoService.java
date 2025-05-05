package com.alexisabel.course.departamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> getDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> getDepartamento(Long departamentoId) {
        return departamentoRepository.findById(departamentoId);
    }

    public void addDepartamento(DepartamentoDTO dto) {
        Departamento departamento = new Departamento(dto.getNombre(), dto.getResponsable());
        departamentoRepository.save(departamento);
    }

    public void deleteDepartamento(Long departamentoId) {
        boolean exists = departamentoRepository.existsById(departamentoId);
        if(!exists) {
            throw new IllegalStateException("El departamento con el id "+departamentoId+" does not exist");
        }
            departamentoRepository.deleteById(departamentoId);
    }
    @Transactional
    public void updateDepartamento(Long id, DepartamentoDTO dto) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El departamento con id: " + id + " no existe."));

        if (dto.getNombre() != null && !dto.getNombre().isEmpty()) {
            departamento.setNombre(dto.getNombre());
        }
        if (dto.getResponsable() != null && !dto.getResponsable().isEmpty()) {
            departamento.setResponsable(dto.getResponsable());
        }
    }

}
