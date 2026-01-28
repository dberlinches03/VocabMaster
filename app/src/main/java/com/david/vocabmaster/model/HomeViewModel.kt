package com.david.vocabmaster.model

import androidx.lifecycle.ViewModel
import com.david.vocabmaster.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val repository = WordRepository()

    private val _currentWord = MutableStateFlow<Word?>(null)
    val currentWord: StateFlow<Word?> = _currentWord

    init {
        loadNewWord()
    }

    fun loadNewWord() {
        _currentWord.value = repository.getRandomWord()
    }
}