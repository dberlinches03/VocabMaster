package com.david.vocabmaster.ui.learned

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.repository.LearnedRepository
import com.david.vocabmaster.data.room.LearnedWord
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class LearnedWordsViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = LearnedRepository(app)

    val words: StateFlow<List<LearnedWord>> =
        repo.getAll().stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}