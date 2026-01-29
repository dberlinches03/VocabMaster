# VocabMaster — Rama `DataStore`

Esta rama implementa la persistencia de preferencias del usuario utilizando **Jetpack DataStore (Preferences)**.

## Funcionalidades incluidas
- Guardado del **tema** (modo claro/oscuro)
- Guardado del **idioma seleccionado**
- Persistencia del **último acceso** para el cálculo del streak
- Flujo reactivo mediante `Flow` y `stateIn`
- Integración con `SettingsViewModel` y la pantalla de Ajustes

## Objetivo
Proporcionar un sistema de preferencias moderno, seguro y eficiente que sustituya a SharedPreferences y permita que la app recuerde configuraciones entre sesiones.

## Archivos principales
- `UserPreferences.kt`
- `SettingsViewModel.kt`
- `SettingsScreen.kt`
