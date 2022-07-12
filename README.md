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
### Paquete model
- Clase UserModel contiene el modelo del usuario
### Paquete listeners
- Clase TestNGListeners contiene los listeners
### Paquete data.factory
- Clase UserModelFactory generación de datos a partir JavaFaker y el builder
### Paquete builder
- Clase UserModelBuilder contiene el builder para la clase UserModel
### Paquete resources
- Archivo config.properties contiene las configuraciones necesarias
- Archivo log4j2.properties contiene la estructura del log
# Generación de datos
## Java Faker
Uso de java faker para el registro exitoso
## Datos estáticos
Configurables en el archivo config.properties
```
DEFAULT_EMAIL=DEFAULT_EMAIL
DEFAULT_PASSWORD=DEFAULT_PASSWORD
```
# Patrones de Diseño
- Page Object Model
- Builder Pattern
- Factory | Object Mother Pattern <br>
Usados para la generacion de datos usando java faker y clase base de selenium
# Correr Tests

## Ejecutar desde la consola
```
mvn -Dtest=Tests test
```
## Ejecutar tests en paralelo
- **Ejecutar desde la suite** <br>
Para ejecutarlo desde la suite de TestNG ejecutar el archivo llamado testng.xml y modificar el thread-count<br>
## Ejecutar tests en remoto
- **Ejecutar desde selenoid** <br>
Para ejecutar desde selenoid modificar en archivo config.properties y dejar obligatoriamente remote=true
```
browser=chrome
REMOTE_URL=serverUrl
remote=true
browserRemoteVersion=81.0
enableVNC=true
enableVideo=false
```
# Allure Report
Despues de haber ejecutado los tests, correr en la consola el siguiente comando
```
allure serve allure-results
```
# Tests fallidos
Generará una screenshot y la guardara en failed_tests con el nombre del test

# Listener de TestNG
listener de TestNG para ocupar log4j los cuales se guardaran en logs/automation.log
