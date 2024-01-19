package com.example.sleeptrackerapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(
    viewModel: SleepViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
               ) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
       ){
        composable(Screen.HomeScreen.route){
            Homepage(navController = navController, viewModel = viewModel)
        }
        composable(Screen.AddScreen.route){
            AddEditSleepView(id = 0L, viewModel = viewModel , navController = navController )
        }
    }

}