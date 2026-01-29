# VocabMaster — Rama `Room`

Esta rama añade la base de datos local utilizando **Room**, permitiendo almacenar las palabras que el usuario marca como aprendidas.

## Funcionalidades incluidas
- Entidad `LearnedWord`
- DAO `LearnedWordDao`
- Base de datos `AppDatabase`
- Repositorio `LearnedRepository`
- Integración con `HomeViewModel` para guardar palabras aprendidas
- Pantalla `LearnedWordsScreen` para visualizar el historial

## Objetivo
Permitir que el usuario mantenga un registro persistente de las palabras aprendidas, incluso tras cerrar la aplicación.

## Archivos principales
- `LearnedWord.kt`
- `LearnedWordDao.kt`
- `AppDatabase.kt`
- `LearnedRepository.kt`
- `LearnedWordsScreen.kt`
