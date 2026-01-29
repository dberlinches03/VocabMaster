package com.david.vocabmaster.ui.stats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.datastore.UserPreferences
import com.david.vocabmaster.data.repository.LearnedRepository
import com.david.vocabmaster.utils.daysBetween
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class StatsViewModel(app: Application) : AndroidViewModel(app) {

    private val prefs = UserPreferences(app)
    private val repo = LearnedRepository(app)

    val totalWords = repo.count()
        .stateIn(viewModelScope, SharingStarted.Eagerly, 0)

    val streak = prefs.streakFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, 0)

    val lastAccess = prefs.lastAccessFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, 0L)

    init {
        updateStreak()
    }

    private fun updateStreak() {
        viewModelScope.launch {
            val today = System.currentTimeMillis()
            val last = prefs.lastAccessFlow.first()
            val diff = daysBetween(last, today)

            val newStreak = when {
                last == 0L -> 1
                diff == 1 -> streak.value
                diff == 1 -> streak.value + 1
                else -> 1
            }

            prefs.updateAccessDate(today, newStreak)
        }
    }
}