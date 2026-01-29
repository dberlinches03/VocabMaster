package com.david.vocabmaster.ui.game

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.david.vocabmaster.data.repository.WordRepository
import com.david.vocabmaster.model.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = WordRepository()

    private val _currentWord = MutableStateFlow<Word?>(null)
    val currentWord: StateFlow<Word?> = _currentWord

    private val _options = MutableStateFlow<List<String>>(emptyList())
    val options: StateFlow<List<String>> = _options

    private val _selected = MutableStateFlow<String?>(null)
    val selected: StateFlow<String?> = _selected

    private val _isCorrect = MutableStateFlow<Boolean?>(null)
    val isCorrect: StateFlow<Boolean?> = _isCorrect


    init {
        newRound()
    }

    fun newRound() {
        viewModelScope.launch {
            val word = repo.getRandomWord()
            _currentWord.value = word
            val wrong = (1..3).map { repo.getRandomWord().definition}
            val all = (wrong + word.definition).shuffled()

            _options.value = all
            _selected.value = null
            _isCorrect.value = null

        }
    }
    fun selectOption(def: String) {
        _selected.value = def
        _isCorrect.value = (def ==_currentWord.value?.definition)

    }
}