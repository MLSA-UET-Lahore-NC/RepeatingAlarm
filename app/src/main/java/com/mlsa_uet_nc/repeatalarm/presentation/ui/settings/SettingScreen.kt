package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.CustomLabel
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.HeaderBar
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.SettingItem
import com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components.SettingItem2
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.RepeatingAlarmTheme

@Composable
fun SettingScreen() {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item(){

            Spacer(Modifier.heightIn(min = 30.dp))
            HeaderBar(text = "Settings", imageVector = Icons.Default.ArrowBack)

            Spacer(Modifier.heightIn(min = 10.dp))
        }
        item() {

            CustomLabel("Settings")
            SettingItem2(text = "Notification", vectorImage = Icons.Default.KeyboardArrowRight)
            SettingItem(text = "Show Fajr's Imsak & Syuruk")
            SettingItem(text = "Show Dhuha Prayer Time")
            SettingItem(text = "Use Dark Mode")
            SettingItem(text = "Use 24H Time Format")

        }
        item(){
            CustomLabel("About the App")
            SettingItem2("App's Info", null)
            SettingItem2("Privacy Policy", null)
        }
    }
}

@PreviewLightDark
@Composable
fun SettingScreenPreview() {

    RepeatingAlarmTheme {
        SettingScreen()
    }

}