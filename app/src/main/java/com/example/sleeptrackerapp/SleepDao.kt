package com.example.sleeptrackerapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.Update
import kotlinx.coroutines.flow.Flow // Correct import
import java.time.LocalDate


@Dao
@TypeConverters(LocalDateConverter::class)
interface SleepDao {

    @Insert
    suspend fun insert(sleep: Sleep): Long

    @Update
    suspend fun update(sleep: Sleep)

//     gets all the sleep data from the sleep table
    @Query("SELECT * FROM sleepTable ORDER BY date DESC")
     fun getAllSleepData(): Flow<List<Sleep>>

     @Query("SELECT * FROM sleepTable WHERE date = :targetDate  ORDER BY date DESC")
     fun getSleepSpecificDate(targetDate : LocalDate): Flow<Sleep>

     @Delete
     suspend fun deleteSleep(sleep: Sleep)
}