package com.pranjal.codersclock.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Contest::class), version = 1)
abstract class ContestDatabase: RoomDatabase() {

    abstract fun contestDao(): ContestDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ContestDatabase? = null

        fun getDatabase(context: Context): ContestDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContestDatabase::class.java,
                    "contest_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}