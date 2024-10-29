package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.WheelTimePicker
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime

@Composable
fun QuickScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        var time by remember { mutableStateOf(LocalTime.of(0,0)) }
        var timerRunning by remember { mutableStateOf(false) }
        var startTime by remember { mutableStateOf(LocalTime.of(0,0))}
        var progress by remember { mutableStateOf(0) }
        var isPaused by remember { mutableStateOf(false) }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Set Quick Alarm",
                style = MaterialTheme.typography.headlineMedium,
            )

            if(!timerRunning) {
                WheelTimePicker(
                    Modifier.padding(vertical = 14.dp),
                    size = DpSize(200.dp, 200.dp),
                    startTime = time,
                ) { snappedTime ->
                    time = snappedTime
                }
                Button(
                    onClick = {
                        isPaused = false
                        timerRunning = true
                        startTime = time
                        GlobalScope.launch {
                            while (timerRunning) {
                                if(!isPaused) time = time.minusSeconds(1)

                                val totalSeconds = java.time.Duration.between(LocalTime.of(0, 0), startTime).seconds
                                val remainingSeconds = java.time.Duration.between(LocalTime.of(0, 0), time).seconds
                                progress = ((totalSeconds - remainingSeconds).toDouble() / totalSeconds * 100).toInt()

                                if(time == LocalTime.of(0, 0)) {
                                    timerRunning = false
                                    time = startTime
                                    break
                                }
                                delay(1000L)
                            }
                        }
                    }, enabled = time != LocalTime.of(0, 0)
                ) {
                    Text(
                        "Start Quick Alarm",
                        Modifier.padding(6.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            else if(timerRunning) {
                Box (modifier = Modifier.padding(vertical = 48.dp)) {
                    Box(
                        modifier = Modifier.size(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            progress = { progress / 100f },
                            modifier = Modifier.size(236.dp),
                            strokeWidth = 14.dp, // Adjust stroke width
                            trackColor = colorScheme.surfaceVariant,
                            strokeCap = StrokeCap.Round,
                        )
                        Text(
                            text = "${time.hour}:${time.minute}:${time.second}",
                            style = MaterialTheme.typography.headlineLarge,
                            color = colorScheme.primary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        colors = buttonColors(
                            containerColor = if (isPaused) colorScheme.primary else colorScheme.outline
                        ),
                        onClick = {
                        isPaused = !isPaused
                    }) {
                        Text(
                            text = if (isPaused) "Resume" else "Pause",
                            Modifier.padding(6.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Button(
                        colors = buttonColors(containerColor = colorScheme.outline),
                        onClick = {
                            progress = 0
                            timerRunning = false
                            time = startTime
                        }) {
                        Text(
                            "Stop",
                            Modifier.padding(6.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    QuickScreen()
}