package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.SampleData

@Composable
fun AlarmListItem(
    alarmItem : AlarmListItem,
    modifier : Modifier = Modifier,
) {
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
    ){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {  },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = alarmItem.timeRange,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = alarmItem.interval,
                    style = MaterialTheme.typography.labelMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    alarmItem.days,
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Switch(
                checked = alarmItem.isActive,
                onCheckedChange = {  }
            )
        }
    }

}

@PreviewLightDark
@Preview
@Composable
fun AlarmListItemPreview() {
    AlarmListItem(
        alarmItem = SampleData.alarmListSampleData[0]
    )
}