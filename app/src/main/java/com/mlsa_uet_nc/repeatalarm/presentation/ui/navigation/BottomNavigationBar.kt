package com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mlsa_uet_nc.repeatalarm.R

sealed class BottomNavItem(val route: String, val title: String, val icon: @Composable () -> Unit) {
    object Quick : BottomNavItem("quick", "Quick Alarm", { Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_clock_quick), contentDescription = "Quick") })
    object List : BottomNavItem("list", "Alarms List", { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "List") })
    object Settings : BottomNavItem("settings", "Settings", { Icon(Icons.Default.Settings, contentDescription = "Settings") })
}

@Composable
fun BottomNavigationBar(
    currentRoute : String?,
    navController: NavController
) {
    val items = listOf(BottomNavItem.Quick, BottomNavItem.List, BottomNavItem.Settings)

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth(),
        tonalElevation = 5.dp
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = { item.icon() },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray
                )
            )
        }
    }
}
