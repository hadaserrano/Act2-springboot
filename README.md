# Actividad 2 – Arquitecturas en la Nube  
## Proyecto Spring Boot + CI/CD con GitHub Actions

Este proyecto forma parte de la Actividad 2 de la asignatura Arquitecturas en la Nube.  
El objetivo es crear una aplicación Spring Boot y configurar un pipeline completo de CI/CD usando GitHub Actions, simulando un despliegue en AWS Elastic Beanstalk.

## 1. Estructura del proyecto

```
Act2-springboot/
 ├── .idea/
 ├── .github/
 │    └── workflows/
 │         ├── ci.yml
 │         └── cd.yml
 ├── .mvn/
 ├── src/
 │    └── main/
 │         └── java/
 │              └── com/
 │                   └── example/
 │                        └── Act2_springboot/
 │                             ├── Act2SpringbootApplication.java
 │                             ├── EstadoController.java
 │                             └── RootController.java
 ├── target/
 ├── pom.xml
 └── README.md
```

## 2. Pipeline CI (Integración Continua)

Archivo: `.github/workflows/ci.yml`

El pipeline de CI se ejecuta automáticamente en cada push a la rama main.

Acciones que realiza:

1. Descarga el repositorio  
2. Instala JDK 17  
3. Compila el proyecto con Maven  
4. Ejecuta los tests  
5. Comprueba que se genera el .jar correctamente 

Este pipeline asegura que el proyecto siempre se mantiene en un buen estado antes de hacer cambios.

## 3. Pipeline CD (Despliegue Continuo)

Archivo: `.github/workflows/cd.yml`

El pipeline de CD no es automático.  
Se ejecuta manualmente desde GitHub Actions mediante workflow_dispatch.

Pasos que realiza:

1. Descarga el repositorio.
2. Instala JDK 17.
3. Compila el proyecto con Maven.
4. Copia el .jar generado a la carpeta deploy/
5. Genera un archivo app.zip con el .jar dentro
6. Guarda el ZIP como artefacto (simulando que se enviaría a AWS)
7. Muestra un mensaje indicando que aquí iría el despliegue real


El despliegue real a AWS Elastic Beanstalk se haría aquí cuando se disponga de credenciales.

## 4. Generación del artefacto de despliegue (ZIP)

Para simular el despliegue en AWS, se genera un archivo app.zip que contiene el .jar final.

Pasos realizados:

mvn package  
mkdir deploy  
cp target/*.jar deploy/app.jar  
cd deploy  
zip -r app.zip app.jar

El archivo final se encuentra en:

deployment/app.zip

Este ZIP es el que se subiría a AWS Elastic Beanstalk.

## 5. Cómo se desplegaría en AWS (cuando haya credenciales)

1. Acceder a AWS Elastic Beanstalk  
2. Crear una aplicación Java  
3. Subir el archivo app.zip  
4. Elastic Beanstalk se encarga del resto (instalar Java, ejecutar el jar, logs, etc.)

## 6. Estado actual del proyecto

- CI funcionando correctamente  
- CD configurado y ejecutándose manualmente  
- ZIP generado y guardado como artefacto  
- Simulación del despliegue incluida  
- Proyecto listo para integrarse con AWS cuando se disponga de credenciales
