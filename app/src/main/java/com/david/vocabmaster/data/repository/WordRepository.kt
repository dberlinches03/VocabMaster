package com.david.vocabmaster.data.repository

import com.david.vocabmaster.model.Word

class WordRepository {

    private val words = listOf(
        Word("Xenofobia", "Rechazo u odio hacia los extranjeros."),
        Word("Perro", "Mamífero doméstico de la familia de los cánidos."),
        Word("Ecléctico", "Que combina elementos de diferentes estilos."),
        Word("Efímero", "Que dura muy poco tiempo."),
        Word("Resiliencia", "Capacidad de adaptarse y superar dificultades.")
    )

    fun getRandomWord(): Word {
        return words.random()
    }
}