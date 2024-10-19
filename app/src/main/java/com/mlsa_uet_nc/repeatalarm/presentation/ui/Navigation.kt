package com.mlsa_uet_nc.repeatalarm.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.BottomNavigationBar
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.NavHostContainer

@Composable
fun Navigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHostContainer(navController, Modifier.padding(innerPadding))
    }
}