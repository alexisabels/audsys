# AudSys
### Gestión de auditorías para empresas
AudSys es una aplicación pensada para ayudar a pequeñas empresas a tener controlados sus procesos de calidad. Permite organizar auditorías, registrar lo que se encuentra en ellas, asignar responsables y hacer seguimiento de las acciones que hay que tomar.

## Características

- Gestión de departamentos y auditores.
- Registro de auditorías con categorías, tipo y fecha.
- Observaciones asociadas a cada auditoría con distintos niveles de criticidad.
- Planes de acción vinculados a auditorías para realizar seguimiento de medidas correctivas.
- Validación de entrada a través de DTOs.
- Documentación con Swagger UI.

## Tecnologías

- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- MySQL (local)
- Swagger 2.8
- Maven

## Estructura del proyecto

- `Departamento`: entidad del departamento que pasa auditorías, con responsable.
- `Auditor`: persona encargada de realizar las auditorías.
- `Auditoría`: entidad principal con relación a observaciones y planes.
- `Observación`: comentarios o hallazgos encontrados durante una auditoría.
- `Plan de acción`: medidas a tomar frente a observaciones registradas en una auditoría, aplicables a un departamento.

## Endpoints principales

- `GET /api/v1/auditoria`
- `GET /api/v1/auditor`
- `GET /api/v1/departamento`
- `GET /api/v1/observacion`
- `GET /api/v1/planAccion`

(Disponible también POST, PUT y DELETE para cada entidad).

## Ejemplo de uso

### Obtener auditorías registradas

`GET /api/v1/auditoria`

```json
[
  {
    "id": 3,
    "fecha": "2025-12-10",
    "tipo": "INTERNA",
    "categorias": ["CALIDAD", "SEGURIDAD"],
    "departamento": {
      "id": 1,
      "nombre": "IT",
      "responsable": "Alejandro Isabel"
    },
    "auditor": {
      "id": 1,
      "nombre": "Fulano Mengano",
      "email": "fmengano@gmail.com"
    },
    "observaciones": [
      {
        "id": 1,
        "descripcion": "Falta de documentación adecuada en el área de control de calidad",
        "criticidad": "BAJA"
      }
    ],
    "planesAccion": [
      {
        "id": 1,
        "descripcion": "Actualizar los procedimientos internos y garantizar que toda la documentación esté correcta",
        "estado": "PENDIENTE"
      }
    ]
  }
]
```
Puedes ver más endpoints [aquí](https://alexisabels.github.io/)
## Próximos pasos

- [ ] Implementar frontend con React.
- [ ] Soporte para exportación de informes.
- [ ] Añadir autenticación y control de accesos.
- [ ] Añadir paginación y ordenación en los endpoints

Desarrollado por alexisabel  
Contacto: [isabelsanchezalex@gmail.com](mailto:isabelsanchezalex@gmail.com)
Web: [alexisabel.com](alexisabel.com)
