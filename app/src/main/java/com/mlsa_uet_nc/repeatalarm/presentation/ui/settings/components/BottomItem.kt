package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.LightGreen
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.RepeatingAlarmTheme

@Composable
fun BottomItem() {

    val radioOptions = listOf("15 Mins Before", "10 Mins Before", "5 Mins Before")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Notify me before prayer ends",
            modifier = Modifier.padding(horizontal = 16.dp), style = TextStyle(
            fontWeight = FontWeight.W600,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        ))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    "10 Mins Before", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        fontStyle = FontStyle.Normal,
                        color = Color.Gray
                    )
                )
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null,
                    modifier = Modifier,
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Gray,
                        selectedColor = LightGreen
                    )
                )
            }

        }

    }


}

@Composable
fun BottomItem2() {

    val radioOptions = listOf("15 Mins Before", "10 Mins Before", "5 Mins Before")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Notify me before prayer starts",
            modifier = Modifier.padding(horizontal = 16.dp), style = TextStyle(
                fontWeight = FontWeight.W600,
                fontStyle = FontStyle.Normal,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            ))
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    "10 Mins Before", style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        fontStyle = FontStyle.Normal,
                        color = Color.Gray
                    )
                )
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null,
                    modifier = Modifier,
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Color.Gray,
                        selectedColor = LightGreen
                    )
                )
            }

        }

    }


}

@PreviewLightDark
@Composable
fun BottomItemPreview() {
    RepeatingAlarmTheme {
        BottomItem()
    }
}