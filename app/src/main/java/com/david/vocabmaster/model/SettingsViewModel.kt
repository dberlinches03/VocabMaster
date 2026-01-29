package com.david.vocabmaster.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.datastore.UserPreferences
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(app: Application) : AndroidViewModel(app) {
    private val prefs = UserPreferences(app)

    val darkMode = prefs.darkModeFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)
    val language = prefs.languageFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly,"es")

    fun setDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            prefs.setDarkMode(enabled)
        }
    }

    fun setLanguage(language: String) {
        viewModelScope.launch {
            prefs.setLanguage(language)
        }
    }
}