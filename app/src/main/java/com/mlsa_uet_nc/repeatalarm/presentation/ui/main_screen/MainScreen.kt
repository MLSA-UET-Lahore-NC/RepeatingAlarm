package com.mlsa_uet_nc.repeatalarm.presentation.ui.main_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mlsa_uet_nc.repeatalarm.presentation.ui.add_alarm.AddAlarmBottomSheet
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.BottomNavItem
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.BottomNavigationBar
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.NavHostContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = MainScreenViewModel()
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val sheetSate = rememberModalBottomSheetState(true)
    val showBottomSheet by viewModel.showBottomSheet.collectAsState()

    val scrollBarBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState()
    )

    Scaffold(
        //modifier = Modifier.nestedScroll(scrollBarBehavior.nestedScrollConnection),
        //TODO: uncomment this line
        topBar = {
            when (currentRoute) {
                BottomNavItem.List.route -> {
                    LargeTopAppBar(
                        title = { Text(text = BottomNavItem.List.title) },
                        scrollBehavior = scrollBarBehavior,
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigationBar(
                currentRoute = currentRoute,
                navController
            )
        },
        floatingActionButton = {
            when (currentRoute) {
                BottomNavItem.List.route -> {
                    FloatingActionButton(
                        onClick = {
                            viewModel.toggleBottomSheet(true)
                        }
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Alarm")
                    }
                }
            }
        }
    ) { innerPadding ->

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    viewModel.toggleBottomSheet(false)
                },
                sheetState = sheetSate,
                shape = RectangleShape
            ){
                AddAlarmBottomSheet()
            }
        }
        NavHostContainer(navController, Modifier.padding(innerPadding))
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}