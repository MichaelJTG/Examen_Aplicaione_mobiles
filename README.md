# 💎 Royal Collection App (Examen 2)

Una aplicación Android moderna y elegante para visualizar una colección exclusiva de productos, desarrollada con **Jetpack Compose** y **Clean Architecture**.

## 📱 Capturas de Pantalla
<img width="474" height="953" alt="image" src="https://github.com/user-attachments/assets/b29ece11-fdac-479a-8b4f-1483578b9979" />



## 🚀 Características
* **Diseño Deluxe:** Interfaz de usuario "Premium" con paleta de colores Verde Bosque y Dorado.
* **Consumo de API:** Conexión a servicios REST con paginación automática.
* **Arquitectura MVVM:** Separación limpia entre UI, ViewModel y Datos.
* **Manejo de Errores:** Gestión de estados de carga (Loading), éxito (Success) y error (Error) con opción de reintentar.

## 🛠️ Tecnologías Usadas
* **Lenguaje:** [Kotlin](https://kotlinlang.org/)
* **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material Design 3)
* **Red:** Retrofit + Gson
* **Imágenes:** Coil (Carga asíncrona)
* **Concurrencia:** Coroutines & Flow

## 📂 Estructura del Proyecto
El código está organizado siguiendo principios de Clean Code:
* `data/`: Modelos de respuesta (PagedResponse) y conexión a la API.
* `presentation/`: ViewModel y gestión de estados (UiState).
* `ui/`: Pantallas (ProductosScreen) y componentes visuales personalizados.

## 🔧 Instalación
1.  Clona este repositorio.
2.  Abre el proyecto en **Android Studio**.
3.  Sincroniza los archivos Gradle.
4.  Ejecuta la app en un emulador o dispositivo físico.

---
**Desarrollado por:** [Tu Nombre]
