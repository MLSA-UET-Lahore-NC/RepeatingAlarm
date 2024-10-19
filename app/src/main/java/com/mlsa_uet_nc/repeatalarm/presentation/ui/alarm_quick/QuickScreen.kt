package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text

@Composable
fun QuickScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Quick Screen")
    }
}
