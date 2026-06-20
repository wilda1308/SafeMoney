# SafeMoney
 
**SafeMoney** es una aplicación de escritorio para la gestión de ingresos y finanzas personales, desarrollada en **Java** con **Apache NetBeans**, usando interfaces gráficas **Swing**.
 
La aplicación permite a un usuario registrarse, iniciar sesión y organizar su dinero en diferentes "bolsillos" (categorías financieras): Ahorros Fijos, Gastos Fijos, Gastos Hormiga y Servicios, llevando un registro de cuánto dinero ha ingresado y retirado en cada uno.
 
## Funcionalidades
 
- **Registro e inicio de sesión de usuario** (`FrmRegistro`, `IniciarSesion`): permite crear una cuenta con nombre, edad, correo y contraseña, y luego iniciar sesión validando esas credenciales.
- **Menú principal** (`FrmPrincipal`): pantalla desde la que se accede al perfil del usuario y a los distintos bolsillos financieros.
- **Perfil de usuario** (`frmUsuario`): muestra la información de la cuenta logueada y si se desea modificar algo, como el nombre, edad, correo y contraseña unicamente estando logueado.
- **Bolsillos financieros**, cada uno con su propia pantalla para agregar o retirar dinero y ver estadísticas de lo ingresado/retirado:
  - **Ahorros Fijos** (`frmAhorrosFijos`), se refiere a los ahorros personales de cada persona.
  - **Gastos Fijos** (`frmGastosFijos`), se refiere a los gastos mensuales que debe realizar obligatoriamente cada persona.
  - **Gastos Hormiga** (`frmGastosHormiga`), se refiere a los pequeños gastos diarios de cada persona.
  - **Servicios** (`frmServicios`), se refiere a los gastos en servicios publicos mensuales o anuales de cada persona.
- **Interfaz moderna**: la aplicación usa la librería **FlatLaf** (con el tema *FlatArc* de IntelliJ Themes) para un Look and Feel más actual que el Swing por defecto, por ejemplo: los bordes de los botones.
## Tecnologías utilizadas
 
- **Lenguaje:** Java (JDK 20)
- **IDE:** Apache NetBeans
- **UI:** Swing, con diseño basado en `AbsoluteLayout` (generado por el editor de formularios de NetBeans)
- **Look and Feel:** [FlatLaf](https://www.formdev.com/flatlaf/) 3.6.2 + FlatLaf IntelliJ Themes 3.6.2
- **Build:** Apache Ant (proyecto estándar de NetBeans, `build.xml`)
- **Almacenamiento:** en memoria (`ArrayList<Usuario>` estático). El proyecto **no usa base de datos**; los usuarios y bolsillos se pierden al cerrar la aplicación.
## Modelo de dominio
 
```
Usuario
 ├── ahorroFijo     : AhorrosFijos
 ├── servicio       : Servicios
 ├── gastosHormiga  : GastosHormiga
 └── gastosFijos    : GastosFijos
 
Bolsillo (clase abstracta)
 ├── nombre, descripcion
 ├── cantidadTotal, totalIngresado, totalRetirado
 ├── agregarCantidad(actual, agregar)
 └── retirarCantidad(actual, retirar)
 
EstadisticasBolsillo (interfaz)
 ├── totalDineroIngreado()
 └── totalDineroRetirado()
```
 
Las clases `AhorrosFijos`, `GastosFijos`, `GastosHormiga`, `Servicios` y `Personalizado` extienden de `Bolsillo` e implementan `EstadisticasBolsillo`.
 
## Estructura del proyecto
 
```
SafeMoney/
├── build.xml                          # Script de build de Apache Ant
├── manifest.mf                        # Manifest base del .jar
├── jar/                               # Librerías externas (FlatLaf)
│   ├── flatlaf-3.6.2.jar
│   └── flatlaf-intellij-themes-3.6.2.jar
├── nbproject/                         # Metadatos del proyecto NetBeans
│   ├── build-impl.xml
│   ├── genfiles.properties
│   ├── project.properties
│   └── project.xml
└── src/com/safemoney/
    ├── clases/                        # Lógica de negocio / modelo
    │   ├── Usuario.java
    │   ├── Bolsillo.java
    │   ├── EstadisticasBolsillo.java
    │   ├── AhorrosFijos.java
    │   ├── GastosFijos.java
    │   ├── GastosHormiga.java
    │   ├── Servicios.java
    │   └── Personalizado.java
    ├── gui/                           # Formularios Swing (vista)
    │   ├── IniciarSesion.java / .form   ← clase principal (main)
    │   ├── FrmRegistro.java / .form
    │   ├── FrmPrincipal.java / .form
    │   ├── frmUsuario.java / .form
    │   ├── frmAhorrosFijos.java / .form
    │   ├── frmGastosFijos.java / .form
    │   ├── frmGastosHormiga.java / .form
    │   └── frmServicios.java / .form
    └── imagenes/                      # Recursos gráficos (íconos, fondos)
```
 
> Los archivos `.form` son archivos propios del editor visual de NetBeans (definen el diseño gráfico) y van siempre junto a su `.java` correspondiente.
 
## Requisitos para ejecutar el proyecto
 
- **JDK 20** o superior instalado.
- **Apache NetBeans** (recomendado, ya que el proyecto usa el editor visual de formularios de NetBeans con `AbsoluteLayout`).
## Cómo ejecutar el proyecto
 
### Opción 1: Desde NetBeans (recomendado para ver y modificar el código)
 
1. Abre Apache NetBeans.
2. Ve a **Archivo → Abrir Proyecto** y selecciona la carpeta `SafeMoney/` (la que contiene `build.xml` y `nbproject/`).
3. Espera a que NetBeans resuelva las referencias a las librerías (`flatlaf-3.6.2.jar`, `flatlaf-intellij-themes-3.6.2.jar`, `AbsoluteLayout.jar`).
4. Click derecho sobre el proyecto → **Ejecutar** (o `F6`).
### Opción 2: Ejecutar el `.jar` directamente
 
El `.jar` generado depende de tres librerías externas declaradas en su `Release` (`lib/flatlaf-3.6.2.jar`, `lib/flatlaf-intellij-themes-3.6.2.jar`, `lib/AbsoluteLayout.jar`), por lo que **no es completamente standalone**: esas librerías deben estar en una carpeta `lib/` junto al `.jar`.
 
```bash
java -jar SafeMoney.jar
```
 
> ⚠️ Para ejecutar el archivo del proyecto en Jar se debe tener instalado Java Development Kit JDK versión 20 o superior, de lo contrario no ejecutará, al ejecutar se debe descargar toda la carpeta de Release para que lea las librerias externas.
 
## Uso de la aplicación
 
1. Al iniciar la aplicación se abre la pantalla de **Inicio de Sesión**.
2. Si no tienes cuenta, ve a **Registrarse** para crear un usuario (nombre, edad, correo, contraseña).
3. Inicia sesión con el nombre o correo y la contraseña registrados.
4. Desde el **menú principal** puedes acceder a tu perfil de usuario o a cualquiera de los bolsillos financieros (Ahorros Fijos, Gastos Fijos, Gastos Hormiga, Servicios) para registrar ingresos o retiros y ver tus estadísticas.
5. Puedes ingresar a usuario para modificar algún dato.

## Visualización de SafeMoney (Mockups)

![Interfaz Gráfica de SafeMoney ventana de inicio de sesión](/Imagenes/InicioSesion.png)
![Interfaz Gráfica de SafeMoney ventana de registro](/Imagenes/Registro.png)
![Interfaz Gráfica de SafeMoney ventana principal del aplicativo](/Imagenes/Principal.png)
![Interfaz Gráfica de SafeMoney ventana de bolsillo de gastos fijos](/Imagenes/GastosFijos.png)
![Interfaz Gráfica de SafeMoney ventana de bolsillo de servicios](/Imagenes/Servicios.png)
![Interfaz Gráfica de SafeMoney ventana de bolsillo de ahorros fijos](/Imagenes/AhorrosFijos.png)
![Interfaz Gráfica de SafeMoney ventana de bolsillo de gastos hormiga](/Imagenes/GastosHormiga.png)
![Interfaz Gráfica de SafeMoney ventana de Usuario](/Imagenes/Usuario.png)
## Limitaciones conocidas
 
- Los usuarios y bolsillos **no se persisten**: viven en memoria mientras la aplicación está abierta y se pierden al cerrarla.
- Las contraseñas se almacenan y comparan en texto plano (sin cifrado), por lo que el proyecto es de carácter educativo y no debería usarse en producción tal como está.
- No hay base de datos ni archivo de configuración externo para los datos del usuario.
## Posibles mejoras futuras
 
- Persistencia de datos en una base de datos (MySQL, SQLite, etc.) o en archivos serializados.
- Cifrado de contraseñas (hashing).
- Exportación de estadísticas o historial a PDF/Excel.
- Empaquetado como instalador o `.jar` ejecutable autocontenido (fat jar).
## Autores

Wilson David Monroy Ramirez 
Juan David Rodriguez Linares (Compañero de trabajo)
 
Proyecto académico desarrollado en Java con Apache NetBeans.
 
## Licencia
 
Este proyecto se distribuye con fines educativos.
