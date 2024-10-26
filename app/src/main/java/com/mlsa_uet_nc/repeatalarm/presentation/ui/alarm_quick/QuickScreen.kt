package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.WheelTimePicker
import java.time.LocalTime

@Composable
fun QuickScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        var time by remember { mutableStateOf(LocalTime.of(0,0)) }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Set Quick Alarm",
                style = MaterialTheme.typography.headlineMedium,
            )

            WheelTimePicker (
                Modifier.padding(vertical = 14.dp),
                size = DpSize(200.dp, 200.dp),
                startTime = time,
            ) { snappedTime ->
                time = snappedTime
            }

            Button(
                onClick = {
                    //Todo: start quick alarm
                }, enabled = time != LocalTime.of(0, 0)
            ) {
                Text(
                    "Start Quick Alarm",
                    Modifier.padding(6.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
