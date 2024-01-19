package com.example.sleeptrackerapp

import android.app.TimePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Card
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar
import java.util.Locale
import java.util.concurrent.TimeUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEditSleepView(
    id: Long, //get the specific id of the detail we are adding or deleting
    viewModel: SleepViewModel,
    navController: NavController, // for navigation
) {
    Scaffold(
        topBar = { AppBar(title =if (id != 0L) stringResource(R.string.update_sleep) else stringResource(
            R.string.add_sleep
        ) )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            Spacer(modifier = Modifier.height(8.dp))

            Card (
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = 4.dp
                ) {
                Column (){
                    Datepicker()
                    Spacer(modifier = Modifier.height(4.dp))
                    SleepTimePicker()

                }
            }


        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Datepicker() {

    var value by remember {
        mutableStateOf("")
    }

    DatePickerDialog(onDismissRequest = { /*TODO*/ }, confirmButton = { /*TODO*/ }) {
        
    }


    Column(modifier = Modifier
        .wrapContentSize()
        .padding(8.dp)) {
        Text(
            text = "Select sleep Date:",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(4.dp)
        )
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(state = datePickerState, modifier = Modifier,
                colors = DatePickerDefaults.colors(
                    todayDateBorderColor = colorResource(id = R.color.simply_sky),
                            todayContentColor = colorResource(id = R.color.simply_sky),
                    selectedDayContainerColor = colorResource(id = R.color.simply_sky),
                    weekdayContentColor = Color.Black,
                    dayContentColor = Color.Black,
                    selectedYearContainerColor = colorResource(id = R.color.simply_sky),
                    headlineContentColor = colorResource(id = R.color.simply_sky),
                    titleContentColor = Color.Black,



                )
            )

        }


    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepTimePicker(
     // function to handle Time Selection
) {


    val timeState = rememberTimePickerState(12,0 ,false)
    Text(text = "Selected Sleep time: ${timeState.hour} : ${timeState.minute}")

        TimePicker(
            state = timeState,
            modifier = Modifier,
            colors = TimePickerDefaults.colors(
                clockDialSelectedContentColor = colorResource(id = R.color.simply_sky)
            )
            )
        Spacer(modifier = Modifier.width(8.dp))
//        Button(onClick = { /* TODO: */ }, colors =
//        ButtonDefaults.buttonColors(
//            containerColor = colorResource(id = R.color.simply_sky)
//        )
//        ) {
//            Text(text = "Select sleep Time", color = Color.Black)
//        }


    }






