package com.example.sleeptrackerapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Sleep::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocalDateConverter::class, LocalTimeConverter::class, DurationConverter::class)
abstract class SleepDatabase : RoomDatabase() {
    abstract fun sleepDataDao(): SleepDao
}

