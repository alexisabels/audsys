package com.alexisabel.course.departamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void addDepartamento(Departamento departamento) {
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
    public void updateDepartamento(Long departamentoId, String nombre, String responsable) {
        Departamento departamento = departamentoRepository.findById(departamentoId).orElseThrow(() -> new IllegalStateException("El departamento con id: "+departamentoId+" no existe."));
    if(nombre != null && !nombre.isEmpty() && !Objects.equals(departamento.getNombre(), nombre))
    {
        departamento.setNombre(nombre);
    }
        if(responsable != null && !responsable.isEmpty() && !Objects.equals(departamento.getResponsable(), responsable))
        {
            departamento.setResponsable(responsable);
        }
    }
}
