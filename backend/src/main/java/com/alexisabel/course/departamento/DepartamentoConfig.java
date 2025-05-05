package com.alexisabel.course.departamento;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DepartamentoConfig {
   /*
    @Bean
    CommandLineRunner commandLineRunner(DepartamentoRepository departamentoRepository) {
        return args -> {
            Departamento IT = new Departamento(
                    "IT", "Alejandro Isabel"
            );
            Departamento Finanzas = new Departamento(
                    "Finanzas", "Financiero Financez"
            );
            departamentoRepository.saveAll(List.of(IT, Finanzas));
        };
    }
    */
}
