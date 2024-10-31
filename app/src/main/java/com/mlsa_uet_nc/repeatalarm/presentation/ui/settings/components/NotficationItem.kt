package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
fun NotificationItem(text: String, subText: String, onCLick :() -> Unit) {



    val onChecked = remember { mutableStateOf(false) }
    val interactionSource = remember<MutableInteractionSource> { MutableInteractionSource() }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(1f)
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 19.sp,
                    ))
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    subText,
                    style = TextStyle(
                        color = Color.Gray,
                        fontStyle = FontStyle.Normal,
                        fontSize = 16.sp,
                    ))

            }
            Spacer (modifier = Modifier.weight(1f))

            Switch(
                checked = onChecked.value,
                onCheckedChange = {

                    onChecked.value = it
                    if(it){
                        onCLick.invoke()
                    }

                },
                modifier = Modifier
                    .size(65.dp)
                    .width(65.dp),
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

        if(onChecked.value) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Text(
                    text = "Duration", style = TextStyle(
                        color = Color.DarkGray,
                        fontWeight = FontWeight.W400,
                        fontStyle = FontStyle.Normal,
                        fontSize = 20.sp
                    )
                )

                Text(
                    text = "10 Min's before", style = TextStyle(
                        color = Color.Gray,
                        fontStyle = FontStyle.Normal,
                        fontSize = 18.sp
                    )
                )

            }
        }
        HorizontalDivider(color = Color.LightGray)

    }



}

@PreviewLightDark
@Composable
fun NotificationItemPreview(modifier: Modifier = Modifier) {

    RepeatingAlarmTheme {
//        NotificationItem("UpComing")
    }
}