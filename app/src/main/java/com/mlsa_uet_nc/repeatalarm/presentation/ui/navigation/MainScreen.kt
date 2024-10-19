package com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHostContainer(navController, Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}