package com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_list.AlarmListScreen
import com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick.QuickScreen
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.SettingsScreen

@Composable
fun NavHostContainer(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = BottomNavItem.Quick.route, modifier = modifier) {
        composable(BottomNavItem.Quick.route) { QuickScreen() }
        composable(BottomNavItem.List.route) { AlarmListScreen() }
        composable(BottomNavItem.Settings.route) { SettingsScreen() }
    }
}
