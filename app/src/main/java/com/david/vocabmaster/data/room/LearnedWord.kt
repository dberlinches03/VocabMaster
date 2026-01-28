package com.david.vocabmaster.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learned_words")
data class LearnedWord(
    @PrimaryKey val word: String,
    val definition: String,
    val dateLearned: Long
)