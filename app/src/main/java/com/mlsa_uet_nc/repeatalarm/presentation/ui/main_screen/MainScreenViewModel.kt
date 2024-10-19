package com.mlsa_uet_nc.repeatalarm.presentation.ui.main_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel : ViewModel() {
    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    fun toggleBottomSheet(show: Boolean) {
        _showBottomSheet.value = show
    }
}