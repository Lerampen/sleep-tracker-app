package com.example.sleeptrackerapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "sleepTable")
data class Sleep (
    @PrimaryKey(autoGenerate = true)
    val id : Long, //This is the primary key of the table
    val date : LocalDate,
    val sleepTime : LocalTime,
    val wakeUpTime: LocalTime,
    val totalSleepDuration: Duration
)