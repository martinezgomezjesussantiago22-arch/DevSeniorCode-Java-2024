# Preparando el ambiente

Instalando JDK
  - Instalando Visual Studio Code (VSCode)
  - Instalando extensiones de VSCode
  - Instalando y configurando Git
  - Creando una cuenta en Github

## 1. Instalando JDK
### Windows
1. Descargar la version de [OpenJDK](https://adoptium.net/es/temurin/releases/?version=21) que se desea usar (mínimo la version 21) según el sistema operativo que estés usando.  
Si estamos en windows, escogemos el instalador MSI o EXE para que la instalación sea mas sencilla.  
**Alternativas**:
   * [Adoptium](https://adoptium.net/es/temurin/releases/?version=11)
   * [Amazon Correto](https://aws.amazon.com/es/corretto/)
   * [Azul](https://www.azul.com/downloads/?package=jdk)
   * [IBM](https://www.ibm.com/support/pages/java-sdk-downloads)
   * [Microsoft](https://docs.microsoft.com/es-mx/java/openjdk/download)
   * [Oracle](https://www.oracle.com/java/technologies/downloads/)
1. Ejecuto el archivo descargado con las opciones por defecto.
1. Verifico si java quedó bien instalado en nuestra máquina.
   ```bash
   java -version
   ```

### Linux (Debian o Ubuntu)
1. Actualiza el indice de paquetes
   ```bash
   sudo apt update -y
   sudo apt upgrade -y
   ```
1. Instalar el JDK
   ```bash
   sudo apt install -y temurin-21-jdk
   ```
1. Verifico si java quedó bien instalado en nuestra máquina.
   ```bash
   java -version
   ```

### MacOS
1. Instalar el JDK
   ```bash
   brew tap homebrew/cask-versions
   
   brew install --cask temurin@21
   ```
1. Verifico si java quedó bien instalado en nuestra máquina.
   ```bash
   java -version
   ```

## 2. Instalando Visual Studio Code (VSCode)
### Windows

1. Ve al sitio oficial de [Visual Studio Code](https://code.visualstudio.com/).
1. Haz clic en el botón **Download for Windows**.
1. Abre el archivo descargado y sigue las instrucciones del asistente de instalación.
1. Una vez instalado, abre Visual Studio Code desde el menú de inicio.

### Linux (Debian o Ubuntu)

Este se puede instalar usando [Snap Store](https://snapcraft.io/code) (Recomendado) o usando la terminal como sigue:

1. Abre una terminal.
1. Añade la clave GPG de Microsoft:
   ```bash
   wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > packages.microsoft.gpg 
   
   sudo install -o root -g root -m 644 packages.microsoft.gpg /usr/share/keyrings/
   ```
1. Añade el repositorio de Visual Studio Code:
   ```bash
   sudo sh -c 'echo "deb [arch=amd64 signed-by=/usr/share/keyrings/packages.microsoft.gpg] https://packages.microsoft.com/repos/vscode stable main" > /etc/apt/sources.list.d/vscode.list'
   ```
1. Actualiza la lista de paquetes e instala Visual Studio Code:
   ```bash
   sudo apt update -y
   sudo apt install -y code
   ```

### MacOS
1. Abre una terminal.
1. Instala Visual Studio Code ejecutando:
   ```bash
   brew install --cask visual-studio-code
   ```

## 3. Instalando extensiones de VSCode
Video: [Instalación de extensión de Java en VSCode](https://youtu.be/g6TMxG1xTzU)

### 3.1 Extension Pack for Java
1. Entramos a VSCode
2. Presionamos en la barra de la izquierda el icono de extensiones
3. Presionamos en el símbolo del embudo en la parte superior y buscamos **Category > Extension Packs**
4. En la caja de filtro, agregaremos `Java`
5. Seleccionamos la extension llamada "**Extension Pack for Java**" de **Microsoft** y damos instalar.
6. Esperamos a que termine de instalar las extensiones recomendadas para el trabajo en Java en nuestro entorno.

### 3.2 Extensiones adicionales a instalar
- **vscode-icons** de VSCode Icons Team
- **GitLens - Git supercharged** de **GitKraken** 
- **PlantUML** de **jebbs**

## 4. Instalando y configurando Git
### Windows

1. Ve al [sitio oficial de Git](https://git-scm.com) y descarga el instalador para Windows.
1. Ejecuta el archivo descargado y sigue las instrucciones del asistente de instalación.
1. Durante la instalación, puedes dejar las opciones predeterminadas o personalizarlas según tus preferencias.
1. Una vez completada la instalación, abre **Git Bash** desde el menú de inicio.
1. Configura tu nombre de usuario y correo electrónico:
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tuemail@example.com"
   ```

### Linux (Debian o Ubuntu)
1. Abre una terminal.
1. Actualiza la lista de paquetes:
   ```bash
   sudo apt update -y
   ```

1. Instala Git:
   ```bash
   sudo apt install -y git
   ```

1. Configura tu nombre de usuario y correo electrónico:
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tuemail@example.com"
   ```

### MacOS
1. Abre una terminal.
1. Instala Git usando Homebrew:
   ```bash
   brew install git
   ```
1. Configura tu nombre de usuario y correo electrónico:
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tuemail@example.com"
   ```

## 5. Crear una cuenta en GitHub
### Crear una cuenta en GitHub

1. Ve al [sitio oficial de GitHub](https://github.com/).
1. Haz clic en **Sign up** en la esquina superior derecha.
1. Introduce tu dirección de correo electrónico y haz clic en **Continue**.
1. Crea una contraseña y haz clic en **Continue**.
1. Elige un nombre de usuario y haz clic en **Continue**.
1. Completa el captcha y haz clic en **Create account**.
1. Verifica tu dirección de correo electrónico siguiendo el enlace que te enviaron.

### Configurar la sincronización de datos con la cuenta de Github (opcional)
1. En la barra de actividades, da click en el botón **Accounts** en la parte inferior izquierda.
1. Click en **Backup and Sync Settings...**
1. En la parte superior aparece una lista desplegable con las configuraciones y le das click en el botón **Sign in**.
1. Te sale otra lista preguntando por que tipo de cuenta se va a usar y se selecciona **Sign in with Github**.
1. Abrirá la ventana de inicio de sesión de Github y sigue las instrucciones para iniciar sesión.
1. Una vez que hayas iniciado sesión, podrás elegir qué configuraciones deseas sincronizar. Esto incluye configuraciones, atajos de teclado, fragmentos de usuario, tareas de usuario, estado de la interfaz de usuario y extensiones.
1. Después de configurar la sincronización, VSCode comenzará a sincronizar automáticamente tus configuraciones en segundo plano. Cada vez que inicies sesión en VSCode en otro dispositivo, tus configuraciones se sincronizarán automáticamente.
1. Puedes ajustar qué elementos se sincronizan y cómo se manejan los conflictos desde el menú de configuración de sincronización. Para acceder a esto, haz clic en el icono de engranaje nuevamente y selecciona **Settings Sync: Configure** (Configurar sincronización de configuración).