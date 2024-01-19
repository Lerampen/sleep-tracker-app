package com.example.sleeptrackerapp


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEditSleepView(
    id: Long, //get the specific id of the detail we are adding or deleting
    viewModel: SleepViewModel,
    navController: NavController, // for navigation
) {
    val openDialog = remember {
        mutableStateOf(false)
    }
    var dateResult by remember {
        mutableStateOf("Select sleep date")
    }

    Scaffold(
        topBar = { AppBar(title =if (id != 0L) stringResource(R.string.update_sleep) else stringResource(
            R.string.add_sleep
        ) )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Enter Sleep date:")
                Spacer(modifier = Modifier.width(8.dp))

                OutlinedButton(onClick = { openDialog.value = true }) {
                    Text(text = dateResult)
                }
            }
            Row {
                TimePickerWithDialog()
            }
        }
         if (openDialog.value){
             val datePickerState = rememberDatePickerState()
             val confirmEnabled = derivedStateOf { datePickerState.selectedDateMillis != null }

             DatePickerDialog(
                 onDismissRequest = { openDialog.value = false },
                 confirmButton = { TextButton(onClick = {
                     openDialog.value = false

                     val date: String = if (datePickerState.selectedDateMillis!= null){
                         val formattedDate = try{
                             Tools.convertLongToTime(datePickerState.selectedDateMillis!!)
                         }catch (e: Exception){
                             "format error"
                         }
                         formattedDate
                     }else{
                         "no selection"
                     }
                     dateResult = date
                 }, enabled = confirmEnabled.value
                 ) {
                     Text(text = "Okay")

                 }
                 }) {
                 DatePicker(state = datePickerState)
             }
         }


    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerWithDialog() {
    var selectedHour by remember {
        mutableIntStateOf(0)
    }
    var selectedMinute by remember {
        mutableIntStateOf(0)
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    val timeState = rememberTimePickerState(
        initialHour = selectedHour,
        initialMinute = selectedMinute
    )

    if (showDialog){
        AlertDialog(onDismissRequest = {
            showDialog = false },
            modifier = Modifier.fillMaxWidth()
            ) {
            Column (modifier = Modifier
                .background(colorResource(id = R.color.simply_sky))
                .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TimePicker(state = timeState)
                Row(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { showDialog = false }) {
                        Text(text = "Dismiss")
                    }
                    TextButton(onClick = {
                        showDialog = false
                        selectedHour = timeState.hour
                        selectedMinute = timeState.minute
                    }) {
                        Text(text = "Confirm")

                    }
                }

            }

        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Select Sleep Time: ",
            modifier = Modifier.padding(8.dp))
        OutlinedButton(onClick = { showDialog = true }) {
            Text(text = "${timeState.hour} : ${timeState.minute}")
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun AddSleepPrev() {
    AddEditSleepView(id = 0L, viewModel = SleepViewModel() , navController = rememberNavController())
}




