package com.mlsa_uet_nc.repeatalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import com.mlsa_uet_nc.repeatalarm.presentation.ui.Navigation
import com.mlsa_uet_nc.repeatalarm.presentation.ui.navigation.MainScreen
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.RepeatingAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RepeatingAlarmTheme {
                MainScreen()
            }
        }
    }
}