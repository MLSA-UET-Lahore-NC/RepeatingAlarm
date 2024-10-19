package com.mlsa_uet_nc.repeatalarm.presentation.ui

import com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_list.AlarmListItem

object SampleData {
    val alarmListSampleData = listOf(
        AlarmListItem(
            timeRange = "8:00 AM - 9:00 AM",
            interval = "Every 1 hour",
            days = "Mon, Tue, Wed, Thu, Fri",
            isActive = true
        ),
        AlarmListItem(
            timeRange = "11:00 AM - 12:00 AM",
            interval = "Every 30 min",
            days = "Thu, Fri",
            isActive = false
        ),
        AlarmListItem(
            timeRange = "2:00 PM - 3:00 PM",
            interval = "Every 2 hour",
            days = "Mon, Tue, Wed, Thu, Fri",
            isActive = true
        ),
        AlarmListItem(
            timeRange = "5:00 PM - 6:00 PM",
            interval = "Every 1 hour",
            days = "Mon, Tue, Wed, Thu, Fri",
            isActive = true
        ),
        AlarmListItem(
            timeRange = "8:00 PM - 9:00 PM",
            interval = "Every 1 hour",
            days = "Mon, Tue, Wed, Thu, Fri",
            isActive = true
        ),
        AlarmListItem(
            timeRange = "11:00 PM - 12:00 AM",
            interval = "Every 30 min",
            days = "Thu, Fri",
            isActive = false
        ),
    )
}

