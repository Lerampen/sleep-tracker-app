package com.example.sleeptrackerapp

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.util.Date

class SleepRepository(
    private val sleepDao: SleepDao){

     suspend fun insertSleepData(sleepData: Sleep) {
        sleepDao.insert(sleepData)
     }
    suspend fun updateSleepData(sleepData: Sleep){
        sleepDao.update(sleepData)
    }

    suspend fun deleteSleepDta(sleepData: Sleep){
        sleepDao.deleteSleep(sleepData)
    }

    fun getAllSleepData():Flow<List<Sleep>> =sleepDao.getAllSleepData()

    fun getSpecificSleepData(date: LocalDate): Flow<Sleep>  {
     return  sleepDao.getSleepSpecificDate(date)
    }
}