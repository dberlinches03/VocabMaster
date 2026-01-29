package com.david.vocabmaster.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LearnedWordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(word: LearnedWord)

    @Query("SELECT * FROM learned_words ORDER BY dateLearned DESC")
    fun getAll(): Flow<List<LearnedWord>>

    @Query("SELECT COUNT(*) FROM learned_words")
    fun count(): Flow<Int>

    @Query("SELECT * FROM learned_words WHERE word = :word LIMIT 1")
    suspend fun getByWord(word: String): LearnedWord?
}