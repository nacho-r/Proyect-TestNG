# Selenium-TestNG
Proyecto Maven creado con Selenium, WebdriverManager, TestNG, Log4j, JavaFaker, Allure para automatizar lo siguente en la web https://demo.testfire.net/login.jsp
1. Transferencia entre cuentas
# Estructura del proyecto
### Paquete utils
- Clase DriverFactory contiene métodos para inicializar el driver y obtener el driver
- Clase PropertiesFile contiene método para leer archivos properties
### Paquete tests
- Clase BaseTest para inicializar el driver antes de cada test y cerrarlo despues de cada test
- Clase Tests contiene todo los tests para ejecutar
### Paquete pages
- Clases que modelan las paginas

## Datos estáticos
Configurables en el archivo config.properties
```
DEFAULT_EMAIL=DEFAULT_EMAIL
DEFAULT_PASSWORD=DEFAULT_PASSWORD
```
# Patrones de Diseño
- Page Object Model

