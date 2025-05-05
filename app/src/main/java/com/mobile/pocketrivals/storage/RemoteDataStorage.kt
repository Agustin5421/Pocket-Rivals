package com.mobile.pocketrivals.storage

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mobile.pocketrivals.data.Converters
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.data.HeroDao

@Database(entities = [Hero::class], version = 1)
@TypeConverters(Converters::class)
abstract class PocketRivalsDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    companion object {
        @Volatile
        private var INSTANCE: PocketRivalsDatabase? = null
        fun getDatabase(context: Context): PocketRivalsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PocketRivalsDatabase::class.java,
                    "pocket_rivals_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}