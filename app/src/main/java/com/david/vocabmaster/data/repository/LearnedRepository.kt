package com.david.vocabmaster.data.repository

import android.content.Context
import com.david.vocabmaster.data.room.AppDatabase
import com.david.vocabmaster.data.room.LearnedWord
import kotlinx.coroutines.flow.Flow

class LearnedRepository (context: Context) {
    private val dao = AppDatabase.getDatabase(context).learnedWordDao()

    fun getAll(): Flow<List<LearnedWord>> = dao.getAll()

    fun count(): Flow<Int> = dao.count()

    suspend fun save(word: LearnedWord) {
        dao.insert(word)
    }

    suspend fun exists(word: String): Boolean {
        return dao.getByWord(word) != null
    }
}