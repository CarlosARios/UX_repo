# Pasos para correr la app

1. Clonar el repositorio:
   ```bash
   git clone <URL-del-repo.git>
   ```
2. Abrir el proyecto en Android Studio.
3. Sincronizar Gradle (Build > Sync Project with Gradle Files).
4. Dar permisos de ejecución a gradlew:
   ```bash
   chmod +x gradlew
   ```
5. Limpiar y construir el proyecto:
   ```bash
   ./gradlew clean build
   ```
6. Instalar la app en el dispositivo/emulador:
   ```bash
   ./gradlew installDebug
   ```
7. Iniciar la app:
   ```bash
   adb shell am start -n com.example.tuto_bar_bottom/.MainActivity
   ```

## Error de versión incompatible del Android Gradle Plugin (AGP)

Si aparece un mensaje como:
```
The project is using an incompatible version (AGP 8.9.0) of the Android Gradle plugin.
Latest supported version is AGP 8.8.2
```
Se soluciona cambiando la versión de `com.android.tools.build:gradle` en tu archivo `build.gradle (Project)` o `libs.versions.toml` a la soportada por tu Android Studio (por ejemplo, `8.8.2`).  
```groovy
classpath "com.android.tools.build:gradle:8.8.2"
```
```
