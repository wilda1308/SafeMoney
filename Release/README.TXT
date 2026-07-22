---------------------------------
Ejecutar el ".jar" directamente
---------------------------------
El ".jar" generado depende de tres librerías externas declaradas en su "Release" (`lib/flatlaf-3.6.2.jar`, `lib/flatlaf-intellij-themes-3.6.2.jar`, `lib/AbsoluteLayout.jar`), por lo que **no es completamente standalone**: esas librerías deben estar en una carpeta `lib/` junto al `.jar`.
 
java -jar SafeMoney.jar

 
> ⚠️ Para ejecutar el archivo del proyecto en Jar se debe tener instalado Java Development Kit JDK versión 20 o superior, de lo contrario no ejecutará, al ejecutar se debe descargar toda la carpeta de Release para que lea las librerias externas.

