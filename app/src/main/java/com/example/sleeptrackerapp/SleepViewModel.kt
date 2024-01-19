package com.example.sleeptrackerapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class SleepViewModel(
    private  val sleepRepository: SleepRepository = Graph.sleepRepository
) : ViewModel(){

    private val _sleepData = MutableStateFlow<List<Sleep>>(emptyList())
    val  sleepData : StateFlow<List<Sleep>> = _sleepData

    private val selectedDate = MutableStateFlow<LocalDate?>(null)


    lateinit var getAllSleepData: Flow<List<Sleep>>

    init {
        viewModelScope.launch {
            getAllSleepData = sleepRepository.getAllSleepData()
        }
    }

    fun addSleepData(sleep: Sleep){
        viewModelScope.launch (Dispatchers.IO){
            sleepRepository.insertSleepData(sleep)
            getAllSleepData // refresh
        }
    }

    fun updateSleepData(sleep: Sleep){
        viewModelScope.launch(Dispatchers.IO) {
            sleepRepository.updateSleepData(sleep)
            getAllSleepData
        }
    }

    fun getSleepDataByDate(date: LocalDate): Flow<Sleep>
    = sleepRepository.getSpecificSleepData(date)




}