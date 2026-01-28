package com.david.vocabmaster.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.repository.LearnedRepository
import com.david.vocabmaster.data.repository.WordRepository
import com.david.vocabmaster.data.room.LearnedWord
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    private val repository = WordRepository()
    private val learnedRepo = LearnedRepository(app)


    private val _currentWord = MutableStateFlow<Word?>(null)

    private val _isChanging = MutableStateFlow(false)
    val isChanging: StateFlow<Boolean> = _isChanging
    val currentWord: StateFlow<Word?> = _currentWord

    init {
        loadNewWord()
    }

    fun loadNewWord() {
        _isChanging.value = true

        // Simular animación o carga
        viewModelScope.launch {
            delay(200)
            _currentWord.value = repository.getRandomWord()
            _isChanging.value = false
        }
    }

    fun saveCurrentWord() {
        val w = _currentWord.value ?: return
        viewModelScope.launch {
            learnedRepo.save(
                LearnedWord(
                    w.word,
                    definition = w.definition,
                    dateLearned = System.currentTimeMillis()
                )
            )
        }
    }
}