# ¿Que es Java?

![Java](https://codersfree.nyc3.cdn.digitaloceanspaces.com/posts/operadores-relacionales-en-java.jpg)

Java es un lenguaje de programación y una plataforma informática creada por Sun Microsystems en 1995. Es un lenguaje orientado a objetos, lo que significa que se basa en conceptos de "objetos" que pueden contener datos y código para manipular esos datos.

Una de las características más destacadas de Java es su capacidad de ser ejecutado en diferentes plataformas sin necesidad de modificar el código fuente, gracias a su lema **Write Once, Run Anywhere** (Escribe una vez, ejecuta en cualquier lugar). Esto se logra mediante la compilación del código Java en un formato intermedio llamado bytecode, que luego es interpretado por la Java Virtual Machine (JVM) en cualquier dispositivo.

Java se utiliza ampliamente en el desarrollo de aplicaciones web, aplicaciones móviles (especialmente en Android), sistemas empresariales y mucho más. Además, es conocido por su robustez, seguridad y portabilidad.

La **Java Virtual Machine (JVM)** es una máquina virtual que permite ejecutar programas escritos en el lenguaje de programación Java. Su principal función es interpretar el bytecode de Java, que es un formato intermedio generado por el compilador de Java, y convertirlo en instrucciones que el hardware del sistema pueda ejecutar.

## Características de Java
1. **Portabilidad**: Gracias a la Java Virtual Machine (JVM), el código Java puede ejecutarse en cualquier plataforma que tenga una JVM instalada, sin necesidad de recompilar.
1. **Orientado a objetos**: Java utiliza el paradigma de programación orientada a objetos, lo que facilita la creación de software modular y reutilizable.
1. **Multihilo**: Java soporta la programación multihilo, lo que permite la ejecución de múltiples hilos de ejecución simultáneamente, mejorando el rendimiento de las aplicaciones.
1. **Seguridad**: Java tiene características de seguridad integradas, como la gestión de memoria automática y la verificación de bytecode, que ayudan a prevenir errores y vulnerabilidades.
1. **Robustez**: Java es conocido por su robustez, ya que maneja bien los errores en tiempo de ejecución y tiene una gestión de memoria eficiente.
1. **Distribuido**: Java facilita la creación de aplicaciones distribuidas, gracias a su soporte para tecnologías como RMI (Remote Method Invocation) y CORBA (Common Object Request Broker Architecture).
1. **Interpretado y compilado**: El código Java se compila en bytecode, que luego es interpretado por la JVM. Esto permite que el código sea independiente de la plataforma.
1. **Alto rendimiento**: Aunque Java es interpretado, las JVM modernas utilizan técnicas de compilación Just-In-Time (JIT) para mejorar el rendimiento.

## Compilación y ejecución de aplicaciones Java
![Compilación y ejecución de aplicaciones Java](https://cdn.javarush.com/images/article/fef10693-b1f3-479a-a02e-29414cdc2a79/1024.jpeg)

La compilación y ejecución de aplicaciones Java sigue un proceso bien definido que se puede resumir en los siguientes pasos:

1. **Escribir el código fuente**: Se crea un archivo con extensión .java que contiene el código fuente del programa.
1. **Compilar el código fuente**: Utilizando el compilador `javac` del JDK (Java Development Kit), el código fuente se convierte en bytecode, que es un formato intermedio independiente de la plataforma.
1. **Ejecutar el bytecode**: La JVM (Java Virtual Machine) interpreta y ejecuta el bytecode.

## JDK y JRE
### JDK (Java Development Kit)
- **Propósito**: Es un kit de herramientas completo para desarrollar aplicaciones Java.
- **Componentes**: Incluye el JRE, el compilador `javac`, herramientas de depuración, bibliotecas y otros recursos necesarios para escribir, compilar y depurar programas Java.
- **Uso**: Necesario para los desarrolladores que crean nuevas aplicaciones Java o modifican las existentes.

### JRE (Java Runtime Environment)
- **Propósito**: Proporciona el entorno necesario para ejecutar aplicaciones Java.
- **Componentes**: Incluye la JVM (Java Virtual Machine) y las bibliotecas de clases necesarias para ejecutar programas Java.
- **Uso**: Necesario para los usuarios que solo necesitan ejecutar aplicaciones Java ya compiladas.

En resumen, el JDK es esencial para el desarrollo de software en Java, mientras que el JRE es suficiente para ejecutar aplicaciones Java.

## Modelo de Liberación de Versiones de Java
- Liberaciones Semestrales:
  - Desde 2017, Java adopta un ciclo de liberación de versiones cada seis meses. Esto significa que hay dos versiones nuevas de Java cada año, una en marzo y otra en septiembre.
  - Este modelo permite a los desarrolladores acceder a nuevas características y mejoras de manera más rápida y frecuente.
- Versiones LTS (Long-Term Support):
  - Cada tres años, una de las versiones liberadas se designa como LTS. Las versiones LTS reciben soporte a largo plazo, lo que incluye actualizaciones de seguridad y correcciones de errores durante un período extendido.
  - Las versiones LTS son ideales para entornos de producción donde la estabilidad y el soporte a largo plazo son cruciales. Ejemplos de versiones LTS son Java 8, Java 11, Java 17 y la más reciente, Java 21.
- Versiones No-LTS:
  - Las versiones que no son LTS reciben soporte y actualizaciones solo hasta la siguiente liberación, es decir, durante seis meses. Estas versiones permiten a los desarrolladores experimentar con nuevas características y mejoras antes de que se incluyan en una versión LTS.
- Características en Previsión (Preview Features):
  - Algunas nuevas características se introducen inicialmente como "preview features". Esto permite a los desarrolladores probar y dar feedback sobre estas características antes de que se incluyan oficialmente en una versión futura.
  - Las características en previsión no están habilitadas por defecto y deben activarse explícitamente durante la compilación y ejecución.


## Historia de las [versiones de Java](https://en.wikipedia.org/wiki/Java_version_history)


- Java 1.0 (1995):
  - Introducción de la JVM (Java Virtual Machine).
  - API gráfico AWT (Abstract Window Toolkit).
  - Clases fundamentales para la programación básica.
- Java 1.1 (1997):
  - Soporte para JavaBeans.
  - Introducción de JDBC para la conexión a bases de datos.
  - Mejoras en la internacionalización y la gestión de eventos.
- Java 1.2 (1998):
  - Introducción del framework de Collections.
  - API de Swing para interfaces gráficas más avanzadas.
  - Mejoras en la seguridad y el rendimiento.
- Java 1.3 (2000):
  - Mejoras en la JVM con la introducción de HotSpot.
  - Soporte para JNDI (Java Naming and Directory Interface).
- Java 1.4 (2002):
  - Soporte para XML y expresiones regulares.
  - Mejoras en la criptografía y la gestión de excepciones.
- Java 5 (1.5) (2004):
  - Introducción de tipos genéricos y anotaciones.
  - Mejoras en la concurrencia y la gestión de memoria.
- Java 6 (2006):
  - Mejoras en el rendimiento y la gestión de servicios web.
  - API de compilación dinámica.
- Java 7 (2011):
  - Mejoras en la sintaxis del lenguaje (try-with-resources).
  - Nuevos recolectores de basura.
- Java 8 (2014) LTS:
  - Introducción de expresiones lambda y Streams.
  - Nueva API de fechas y horas (java.time).
  - Mejoras en la programación funcional.
- Java 9 (2017):
  - Proyecto Jigsaw para modularizar el JDK.
  - API de flujo de datos (Reactive Streams).
- Java 10 (2018):
  - Inferencia de tipos locales con var.
  - Mejoras en la recolección de basura.
- Java 11 (2018) LTS:
  - Nuevas funciones de cadena y mejoras en la API HTTP.
  - Eliminación de módulos y APIs obsoletas.
- Java 12 (2019):
  - Mejoras en la JVM y nuevas características de sintaxis.
  - Introducción de switch mejorado (preview).
- Java 13 (2019):
  - Mejoras en la API de memoria y nuevas características de switch.
  - Mejoras en la recolección de basura.
- Java 14 (2020):
  - Introducción de record (preview).
  - Mejoras en la API de excepciones.
- Java 15 (2020):
  - Introducción de sealed classes (preview).
  - Mejoras en la API de texto.
- Java 16 (2021):
  - Mejoras en la API de memoria y pattern matching para instanceof.
  - Nuevas características de record.
- Java 17 (2021) LTS:
  - Nuevas características de Sealed classes.
  - Mejoras en la seguridad y el rendimiento.
- Java 18 (2022):
  - Mejoras en la API de vector y nuevas características de switch.
  - Mejoras en la recolección de basura.
- Java 19 (2022):
  - Mejoras en la API de concurrencia y nuevas características de record.
  - Mejoras en la seguridad.
- Java 20 (2023):
  - Mejoras en la API de memoria y nuevas características de sealed classes.
  - Mejoras en la recolección de basura.
- Java 21 (2024) LTS:
  - Nuevas características de pattern matching y record.
  - Virtual Threads
  - Mejoras en la seguridad y el rendimiento.