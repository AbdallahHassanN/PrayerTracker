package com.example.prayertracker.ui.presentation.LatePrayerRecord

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prayertracker.common.Constants
import com.example.prayertracker.common.Resource
import com.example.prayertracker.usecases.UpdatePrayerCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LatePrayerRecordViewModel
@Inject constructor(
    private val updatePrayerCountUseCase: UpdatePrayerCountUseCase
) : ViewModel() {
    val loading = mutableStateOf(false)
    fun updatePrayerCount(
        id: Int,
    ) = viewModelScope.launch {
        loading.value = true
        updatePrayerCountUseCase.execute(id = id).catch {
            Log.d(Constants.TAG, "Error in VM")
        }.collect { response ->
            when (response) {
                is Resource.Error -> {
                    loading.value = false
                    Log.d(Constants.TAG, "VM Error response")
                }

                is Resource.Loading -> {
                    loading.value = true
                    Log.d(Constants.TAG, "VM Loading")
                }

                is Resource.Success -> {
                    Log.d(Constants.TAG, "VM Updated")
                    loading.value = false
                }
            }
        }
    }
}