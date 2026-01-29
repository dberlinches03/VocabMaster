package com.david.vocabmaster.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LearnedWord::class], version = 1)


abstract class AppDatabase : RoomDatabase() {
    abstract fun learnedWordDao(): LearnedWordDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "vocabmaster_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}