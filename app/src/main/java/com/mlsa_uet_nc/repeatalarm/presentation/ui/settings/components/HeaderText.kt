package com.mlsa_uet_nc.repeatalarm.presentation.ui.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.theme.LightGreen

@Composable
fun HeaderBar(text: String , imageVector: ImageVector) {


    Row(
        modifier = Modifier
            .fillMaxWidth().padding(start = 20.dp , end = 20.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Icon(
            modifier = Modifier.size(30.dp),
            imageVector = imageVector, contentDescription = text
        )
        Spacer(modifier = Modifier.width(15.dp))

        Text(
            text = text, style = TextStyle(
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Spacer(modifier = Modifier.weight(1f))



        if(text != "Settings")
            Text(
               text =  "DONE",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    fontStyle = FontStyle.Normal,
                    color = LightGreen
                )
            )


    }
}

@PreviewLightDark
@Composable
fun HeaderBarPreview(modifier: Modifier = Modifier) {

    HeaderBar(text = "Settings", imageVector = Icons.Default.ArrowBack)
}