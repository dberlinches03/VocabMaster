package com.david.vocabmaster.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.repository.WordRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = WordRepository()

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
}