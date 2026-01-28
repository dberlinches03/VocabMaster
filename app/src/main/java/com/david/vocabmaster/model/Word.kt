package com.david.vocabmaster.model

data class Word (
    val word: String,
    val definition: String,
    val image: Int? = null // Opcional
)