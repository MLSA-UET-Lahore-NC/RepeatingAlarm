package com.mlsa_uet_nc.repeatalarm.presentation.ui.alarm_quick

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime

class QuickAlarmViewModel : ViewModel() {
    private var timerJob: Job? = null

    private val _time = MutableStateFlow(LocalTime.of(0, 0))
    val time = _time.asStateFlow()

    private val _timerRunning = MutableStateFlow(false)
    val timerRunning = _timerRunning.asStateFlow()

    private val _startTime = MutableStateFlow(LocalTime.of(0, 0))

    private val _progress = MutableStateFlow(0)
    val progress = _progress.asStateFlow()

    private val _isPaused = MutableStateFlow(false)
    val isPaused = _isPaused.asStateFlow()

    fun setTime(newTime: LocalTime) {
        _time.value = newTime
    }

    fun startTimer() {
        _isPaused.value = false
        _timerRunning.value = true
        _startTime.value = _time.value

        timerJob = viewModelScope.launch {
            while (_timerRunning.value) {
                if (!_isPaused.value) {
                    _time.value = _time.value.minusSeconds(1)
                }

                val totalSeconds = java.time.Duration.between(LocalTime.of(0, 0), _startTime.value).seconds
                val remainingSeconds = java.time.Duration.between(LocalTime.of(0, 0), _time.value).seconds
                _progress.value = ((totalSeconds - remainingSeconds).toDouble() / totalSeconds * 100).toInt()

                if (_time.value == LocalTime.of(0, 0)) {
                    stopTimer()
                    break
                }
                delay(1000L)
            }
        }
    }

    fun togglePause() {
        _isPaused.value = !_isPaused.value
    }

    fun stopTimer() {
        _timerRunning.value = false
        _progress.value = 0
        _time.value = _startTime.value
        timerJob?.cancel()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
