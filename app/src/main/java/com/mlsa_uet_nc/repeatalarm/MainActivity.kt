package com.mlsa_uet_nc.repeatalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mlsa_uet_nc.repeatalarm.presentation.ui.main_screen.MainScreen
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