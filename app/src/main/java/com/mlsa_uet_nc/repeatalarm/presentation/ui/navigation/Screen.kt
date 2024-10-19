package com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation

sealed class Screen(val route: String) {
    object AddAlarm : Screen("add_alarm")
}