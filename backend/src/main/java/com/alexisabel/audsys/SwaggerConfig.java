package com.alexisabel.audsys;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AudSys API - Sistema de gestión de auditorías")
                        .description("API para la gestión de auditorías internas y externas de una empresa, observaciones, planes de acción y departamentos.\n\n" +
                                "Aplicación de gestión de auditorías internas en Java con Spring Boot + React. Pensada para pequeñas empresas que quieran controlar sus procesos de calidad.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Alejandro Isabel")
                                .url("https://www.alexisabel.com")
                                .email("isabelsanchezalex@gmail.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .externalDocs(new ExternalDocumentation()
                        .description("Repositorio")
                        .url("https://github.com/alexisabels/audsys"))
                .servers(List.of()) // no hay localhost
                .addTagsItem(new Tag().name("Auditorías").description("Operaciones relacionadas con auditorías"))
                .addTagsItem(new Tag().name("Observaciones").description("Anotaciones dentro de las auditorías"))
                .addTagsItem(new Tag().name("Planes de acción").description("Medidas tomadas ante hallazgos"))
                .addTagsItem(new Tag().name("Auditores").description("Gestión de auditores"))
                .addTagsItem(new Tag().name("Departamentos").description("Departamentos auditados"));
    }

    @Bean
    public GroupedOpenApi apiGroup() {
        return GroupedOpenApi.builder()
                .group("audsys")
                .pathsToMatch("/api/**")
                .build();
    }
}
