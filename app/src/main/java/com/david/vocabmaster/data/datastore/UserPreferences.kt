package com.david.vocabmaster.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("user_preferences")

class UserPreferences(private val context: Context) {

    companion object {
        val DARK_MODE = booleanPreferencesKey("dark_mode")
        val LANGUAGE = stringPreferencesKey("language")

        val LAST_ACCESS = longPreferencesKey("last_access")
        val STREAK = intPreferencesKey("streak")
    }
    // Getters
    val darkModeFlow: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[DARK_MODE] ?: false  }

    val languageFlow: Flow<String> = context.dataStore.data
        .map { prefs -> prefs[LANGUAGE] ?: "en" }

    val lastAccessFlow: Flow<Long> = context.dataStore.data
        .map { prefs -> prefs[LAST_ACCESS] ?: 0L }
    val streakFlow: Flow<Int> = context.dataStore.data
        .map { prefs -> prefs[STREAK] ?: 0}

    suspend fun updateAccessDate(today: Long, newStreak: Int) {
        context.dataStore.edit { prefs ->
            prefs[LAST_ACCESS] = today
            prefs[STREAK] = newStreak
        }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[DARK_MODE] = enabled
        }
    }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { prefs ->
            prefs[LANGUAGE] = language
        }
    }
 }