package com.example.musclegym.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.musclegym.dao.SuplementoDao
import com.example.musclegym.model.Suplemento

@Database(entities = [Suplemento::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun suplementoDAO(): SuplementoDao

    companion object {
        private lateinit var INSTANCE: AppDataBase

        fun getDataBase(context: Context): AppDataBase {
            if (!::INSTANCE.isInitialized) {
                synchronized(AppDataBase::class) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDataBase::class.java, "suplementodb")
                            .addMigrations(
                                MIGRATION_1_2, MIGRATION_2_3
                            ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }

        private val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("")
            }
        }
    }
}