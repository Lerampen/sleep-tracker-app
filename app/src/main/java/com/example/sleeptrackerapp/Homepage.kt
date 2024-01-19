package com.example.sleeptrackerapp

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Homepage(
    navController: NavController,
    viewModel: SleepViewModel
) {

    val context = LocalContext.current

    Scaffold(

        modifier = Modifier,
        topBar = { AppBar(title ="Daily Sleep Tracker", onBackNavClicked = {
            Toast.makeText(context,"Button Clicked", Toast.LENGTH_LONG).show()

        })},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context,"FAButton Clicked", Toast.LENGTH_LONG).show()
                        navController.navigate(Screen.AddScreen.route)
                          },
                modifier = Modifier.padding(all= 20.dp),
                contentColor = Color.White,
                containerColor = colorResource(R.color.simply_sky)
            )
            {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new Entry" )

            }
        }
        ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it) ){

        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun HomepagePrev() {
//    Homepage(navController = , viewModel = )
}