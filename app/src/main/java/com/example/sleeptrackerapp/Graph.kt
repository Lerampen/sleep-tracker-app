package com.example.sleeptrackerapp

import android.content.Context
import androidx.room.Room
//a simple example of dependency injection
object Graph {
    lateinit var database : SleepDatabase

//    set up our repository
    val sleepRepository by lazy {
        SleepRepository(database.sleepDataDao())
}

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context,
            SleepDatabase::class.java,
            "sleep.db").build()
    }

}