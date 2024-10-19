package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_list

import androidx.lifecycle.ViewModel

data class AlarmListItem(
    val timeRange: String,
    val interval : String,
    val days : String,
    val isActive: Boolean
)

class AlarmListViewModel: ViewModel() {

}