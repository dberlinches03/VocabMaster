package com.david.vocabmaster.ui.learned

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.david.vocabmaster.data.repository.LearnedRepository

class LearnedWordsViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = LearnedRepository(app)
}