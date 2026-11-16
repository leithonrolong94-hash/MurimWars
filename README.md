# Murim Wars — Sistema web de gestión de inventario

**Evidencia:** GA7-220501096-AA3-EV01  
**Tecnología:** Java 17, Spring Boot 3.5.7, Maven, Spring MVC, Thymeleaf, Spring Data JPA y MySQL.

## 1. Descripción

Aplicación web para registrar, consultar, editar y eliminar productos de una tienda de ropa urbana. El módulo implementa operaciones CRUD y valida los datos principales del inventario.

## 2. Requisitos

- JDK 17 o superior.
- Apache NetBeans 31 (o un IDE compatible con proyectos Maven).
- Maven 3.9+ o Maven Wrapper.
- MySQL 8 para ejecutar con el perfil MySQL. Para una demostración local se incluye H2.

## 3. Abrir el proyecto

1. Descomprimir la carpeta del proyecto.
2. En NetBeans seleccionar **File > Open Project**.
3. Elegir la carpeta que contiene `pom.xml`.
4. Esperar que Maven descargue las dependencias.
5. Ejecutar `MurimwarsApplication.java`.

## 4. Ejecutar en modo demostración (H2)

El perfil predeterminado utiliza H2 local, por lo que se puede iniciar sin configurar MySQL.

En terminal, desde la carpeta del proyecto:

```bash
mvn spring-boot:run
```

En Windows también se puede ejecutar:

```bat
mvnw.cmd spring-boot:run
```

Abrir: http://localhost:8080/productos

Consola H2: http://localhost:8080/h2-console  
JDBC URL: `jdbc:h2:file:./data/murimwars`  
Usuario: `sa`  
Contraseña: (vacía)

## 5. Ejecutar con MySQL

1. Iniciar el servicio MySQL.
2. Ejecutar el script `database/murimwars.sql` en MySQL Workbench.
3. Configurar las variables de entorno `DB_URL`, `DB_USER` y `DB_PASSWORD`, si son diferentes a los valores predeterminados.
4. Ejecutar:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=mysql
```

También se puede activar el perfil `mysql` desde la configuración de ejecución del IDE.

## 6. Funcionalidades del módulo

- Listar productos registrados.
- Registrar un producto.
- Editar un producto.
- Eliminar un producto con confirmación.
- Validar campos obligatorios, precio, stock y SKU único.

## 7. Estructura

```text
src/main/java/com/murimwars/murimwars/
  controller/ProductoController.java
  model/Producto.java
  repository/ProductoRepository.java
  service/ProductoService.java
  MurimwarsApplication.java

src/main/resources/
  application.properties
  application-mysql.properties
  static/css/estilos.css
  templates/productos/lista.html
  templates/productos/formulario.html

database/murimwars.sql
```

## 8. Versionamiento con Git

Desde la terminal, en la carpeta raíz del proyecto:

```bash
git init
git add .
git commit -m "Desarrollo inicial del modulo CRUD de productos"
git branch -M main
```

Crear en GitHub un repositorio vacío llamado `MurimWars-SpringBoot`. Luego conectar el repositorio remoto (reemplazar `USUARIO` por el usuario real de GitHub):

```bash
git remote add origin https://github.com/USUARIO/MurimWars-SpringBoot.git
git push -u origin main
```

**Importante:** el repositorio remoto debe crearse en la cuenta del aprendiz. Este paquete no contiene un enlace de GitHub inventado.

## 9. Observación para la entrega

Antes de entregar, ejecutar y probar las operaciones del sistema, completar el enlace real del repositorio en `ENLACE_REPOSITORIO.txt` y comprimir la carpeta con el nombre solicitado por el instructor.
