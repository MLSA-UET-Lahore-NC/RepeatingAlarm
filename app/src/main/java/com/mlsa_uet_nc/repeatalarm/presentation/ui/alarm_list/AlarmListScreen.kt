package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.mlsa_uet_nc.repeatalarm.presentation.ui.SampleData.alarmListSampleData

@Composable
fun AlarmListScreen(

) {
    AlarmList(
        alarmList = alarmListSampleData
    )
}

@Composable
fun AlarmList(
    alarmList: List<AlarmListItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp, 4.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ){
        items(alarmList.size) { index ->
            AlarmListItem(
                alarmItem = alarmList[index]
            )
        }
    }
}

@PreviewLightDark
@Preview
@Composable
fun PreviewAlarmListScreen() {
    Surface {
        AlarmList(
            alarmList = alarmListSampleData
        )
    }
}