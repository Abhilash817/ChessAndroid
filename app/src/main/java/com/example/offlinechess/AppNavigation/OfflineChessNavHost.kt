package com.example.offlinechess.AppNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.offlinechess.ChessBoardComposables.ChessScreen
import com.example.offlinechess.Home.HomeScreen


@Composable
fun MainApp(){
    val navController= rememberNavController()
   NavHost(
       navController,
       startDestination = "Home"
   ) {
       composable("Home"){
           HomeScreen(goToChessScreen = {
               navController.navigate("ChessScreen")
           })
       }

       composable("ChessScreen"){
           ChessScreen(
               goBackToHomeScreen = {
                   navController.popBackStack()
               }
           )
       }

    }
}