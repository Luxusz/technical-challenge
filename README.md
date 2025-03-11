# Technical-challenge

Desarrolle un proyecto en SpringBoot, para una solución que contenga libros y su relación con el autor. Datos (utilice JPA e Hibernate para el manejo y persistencia a la BD):

Student:
- id
- name
- lastName
- mail
- course_id

Course:
- nameCourse
- teacherCourse
- id


Utilizando, este modelo cree un servicio Api REST que recepcione estos datos y los almacene en una base de datos (mysql o postgres)

Donde estos idealmente se levanten en un ecosistema de MS (parent pom adm), agregando eureka y la configuración para este se consuman por rest donde mediante un cliente http o feign (esto para comunicar las apis) consulte una lista de estudiante para un curso utilice DTO para la transferencia de datos (idealmente utilizar mapStruct) y un api
Gateway para el control de acceso a los recursos.


## Mejoras a considerar
- Validación de datos
- Uso de lombok
- Manejo de excecpiones (RestControllerAdvice)
- ¿Documentar con Swagger?
- Mejorar comportamiento parent -> child
