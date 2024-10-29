package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings

import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.BottomItem
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.BottomItem2
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.CustomLabel
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.HeaderBar
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.NotificationItem
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.SettingItem
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.SettingItem2
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.RepeatingAlarmTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    var showBottomSheet2 by remember {
        mutableStateOf(false)
    }
    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item() {
            Spacer(modifier = Modifier.heightIn(min = 20.dp))
            HeaderBar(
                text = "Notification", imageVector = Icons.Default.Clear
            )
            Spacer(modifier = Modifier.heightIn(min = 30.dp))

        }
        item() {
            CustomLabel(text = "Configurable Reminder")
            Spacer(modifier = Modifier.heightIn(min = 10.dp))
            NotificationItem(
                text = "Upcoming Prayer Time",
                subText = "Notify me before prayer starts",
                onCLick = {
                    showBottomSheet2 = true
                }
            )
            NotificationItem(text = "Prayer Time Ends",
                subText = "Notify me before prayer ends",
                onCLick = {
                    showBottomSheet = true
                }
            )

        }
        item() {
            CustomLabel(text = "Prayer Time Notification")
            Spacer(modifier = Modifier.heightIn(min = 10.dp))
            SettingItem2(text = "Notification Type", Icons.Default.KeyboardArrowRight)
            SettingItem(text = "Fajar")
            SettingItem(text = "Duhar")
            SettingItem(text = "Asr")
            SettingItem(text = "Maghrib")
            SettingItem(text = "Isha'")
        }
    }


    if (showBottomSheet) {

        ModalBottomSheet(
            onDismissRequest = {
                scope.launch{
                    sheetState.hide()
                }
                showBottomSheet = false
            },
            modifier = Modifier.fillMaxSize(),

            sheetState = sheetState,
        ) {
            BottomItem()
        }
    }
    if (showBottomSheet2) {

        ModalBottomSheet(
            onDismissRequest = {
                scope.launch{
                    sheetState.hide()
                }
                showBottomSheet2 = false
            },
            modifier = Modifier.fillMaxSize(),

            sheetState = sheetState,
        ) {
            BottomItem2()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@PreviewLightDark
@Composable
fun NotificationScreenPreview() {

    RepeatingAlarmTheme {

        Scaffold(

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                NotificationScreen()

            }


        }
    }

}