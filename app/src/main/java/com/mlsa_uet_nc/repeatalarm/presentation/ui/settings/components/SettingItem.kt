package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.LightGreen
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.RepeatingAlarmTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingItem(text: String) {
    val onChecked = remember { mutableStateOf(false) }
    val interactionSource = remember<MutableInteractionSource> { MutableInteractionSource() }
    Column(
        modifier = Modifier.fillMaxSize(1f).padding(start = 20.dp , end = 20.dp)
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
                .fillMaxWidth().height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
               text,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                ))
            Spacer (modifier = Modifier.weight(1f))

            Switch(
                        checked = onChecked.value,
                onCheckedChange = {
                    onChecked.value = it
                },
                modifier = Modifier
                    .size(60.dp)
                    .width(60.dp),
                thumbContent = {
                    if (onChecked.value)
                        Icon(
                            tint = LightGreen,
                            imageVector = Icons.Filled.Check,
                            contentDescription = null,
                            modifier = Modifier.size(15.dp)
                        )
                    else
                        null

                },
                enabled = true,

                colors = SwitchDefaults.colors(
                    checkedBorderColor = Color.Transparent,
                    checkedThumbColor = Color.White,
                    checkedTrackColor = LightGreen,
                    uncheckedBorderColor = LightGreen,
                    uncheckedTrackColor = Color.White,
                    uncheckedThumbColor = LightGreen,
                    uncheckedIconColor = LightGreen
                ),
                interactionSource = interactionSource,

                )


        }

        HorizontalDivider(color = Color.LightGray)

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@PreviewLightDark
@Composable
fun SettingItemPreview() {

    RepeatingAlarmTheme {

        LazyColumn(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            item(){

                Spacer(Modifier.heightIn(min = 30.dp))
                HeaderBar(text = "Notification", imageVector = Icons.Default.Clear)

                Spacer(Modifier.heightIn(min = 10.dp))
            }
            item() {

                CustomLabel("Settings")
                SettingItem2(text = "Notification",vectorImage = Icons.Default.KeyboardArrowRight)
                SettingItem(text = "Show Fajr's Imsak & Syuruk")
                SettingItem(text = "Show Dhuha Prayer Time")
                SettingItem(text = "Use Dark Mode")
                SettingItem(text = "Use 24H Time Format")

            }
            item(){
                CustomLabel("About the App")
                SettingItem2("App's Info", null)
                SettingItem2("Privacy Policy",null)
            }
        }
    }
}