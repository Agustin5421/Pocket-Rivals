# Pocket Rivals

## 📱 ¿Qué es Pocket Rivals?

**Pocket Rivals** es una aplicación móvil de compañía para el juego **Marvel Rivals**. Esta app te permite acceder a información detallada sobre héroes, estadísticas de jugadores, notas de actualizaciones y tier lists, todo desde tu dispositivo Android.

## ✨ Características Principales

### 🦸‍♂️ Exploración de Héroes
- **Catálogo completo**: Navega por todos los héroes disponibles en Marvel Rivals
- **Información detallada**: Biografías, habilidades, dificultad y lore de cada héroe
- **Filtrado por roles**: Vanguardia, Estratega y Duelista
- **Búsqueda avanzada**: Encuentra héroes por nombre fácilmente

### 📊 Perfiles de Jugador
- **Autenticación segura**: Inicio de sesión con Google y autenticación biométrica
- **Estadísticas personales**: Tasa de victoria, mejor héroe, historial de partidas
- **Historial de rangos**: Seguimiento de progreso por temporadas
- **Búsqueda de perfiles**: Consulta el perfil de otros jugadores usando su UID

### 📰 Actualizaciones del Juego
- **Notas de parche**: Mantente al día con los últimos cambios del juego
- **Notificaciones**: Recibe alertas sobre nuevas actualizaciones
- **Carrusel de noticias**: Vista visual de las últimas novedades

### 📈 Tier Lists y Estadísticas
- **Rendimiento de héroes**: Porcentajes de victoria, selección y baneos
- **Tier lists actualizadas**: Rankings basados en datos reales del juego
- **Estadísticas de la comunidad**: Datos agregados de todos los jugadores

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **UI Framework**: Jetpack Compose
- **Arquitectura**: MVVM con Hilt para inyección de dependencias
- **Base de datos**: Room Database para almacenamiento local
- **API**: Retrofit para comunicación con Marvel Rivals API
- **Autenticación**: Firebase Auth con Google Sign-In
- **Seguridad**: Autenticación biométrica (huella dactilar)
- **Almacenamiento**: DataStore para preferencias de usuario
- **Imágenes**: Coil para carga y caché de imágenes

## 🚀 Configuración del Proyecto

### Prerrequisitos
- Android Studio Arctic Fox o superior
- JDK 11
- Android SDK API 24 (mínimo) - API 35 (target)

### Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/Agustin5421/Pocket-Rivals.git
   ```

2. Abre el proyecto en Android Studio

3. Configura Firebase:
   - Agrega tu archivo `google-services.json` en la carpeta `app/`
   - Configura la autenticación de Google en Firebase Console

4. Compila y ejecuta:
   ```bash
   ./gradlew assembleDebug
   ```

## 📱 Pantallas Principales

- **🏠 Inicio**: Carrusel de notas de parche y estadísticas de héroes
- **🦸‍♂️ Héroes**: Lista searcheable de todos los héroes con detalles
- **👤 Perfil**: Estadísticas personales y historial de partidas
- **⚙️ Configuración**: Ajustes de la aplicación
- **📋 Notas de Parche**: Últimas actualizaciones del juego

## 🌐 API

La aplicación consume datos de la **Marvel Rivals API** (https://marvelrivalsapi.com) para obtener:
- Información actualizada de héroes
- Estadísticas de rendimiento
- Notas de parche y actualizaciones

## 📄 Licencia

Este proyecto es una aplicación no oficial de compañía para Marvel Rivals. No está afiliada oficialmente con NetEase Games o Marvel.

---

> **Nota**: Esta es una aplicación de fan creada para mejorar la experiencia de juego de Marvel Rivals. Todos los derechos de Marvel Rivals pertenecen a sus respectivos propietarios.