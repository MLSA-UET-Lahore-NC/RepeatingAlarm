package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.commandiron.wheel_picker_compose.WheelTimePicker
import java.time.LocalTime

@Composable
fun QuickScreen(viewModel: QuickAlarmViewModel = viewModel<QuickAlarmViewModel>()) {
    val time by viewModel.time.collectAsState()
    val timerRunning by viewModel.timerRunning.collectAsState()
    val progress by viewModel.progress.collectAsState()
    val isPaused by viewModel.isPaused.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Set Quick Alarm",
                style = MaterialTheme.typography.headlineMedium,
            )

            if (!timerRunning) {
                WheelTimePicker(
                    Modifier.padding(vertical = 14.dp),
                    size = DpSize(200.dp, 200.dp),
                    startTime = time,
                ) { snappedTime ->
                    viewModel.setTime(snappedTime)
                }
                Button(
                    onClick = { viewModel.startTimer() },
                    enabled = time != LocalTime.of(0, 0)
                ) {
                    Text(
                        "Start Quick Alarm",
                        Modifier.padding(6.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                Box(modifier = Modifier.padding(vertical = 48.dp)) {
                    Box(
                        modifier = Modifier.size(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            progress = { progress / 100f },
                            modifier = Modifier.size(236.dp),
                            strokeWidth = 14.dp,
                            trackColor = MaterialTheme.colorScheme.surfaceVariant,
                            strokeCap = StrokeCap.Round,
                        )
                        Text(
                            text = "${time.hour}:${time.minute}:${time.second}",
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isPaused)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.outline
                        ),
                        onClick = { viewModel.togglePause() }
                    ) {
                        Text(
                            text = if (isPaused) "Resume" else "Pause",
                            Modifier.padding(6.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.outline
                        ),
                        onClick = { viewModel.stopTimer() }
                    ) {
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