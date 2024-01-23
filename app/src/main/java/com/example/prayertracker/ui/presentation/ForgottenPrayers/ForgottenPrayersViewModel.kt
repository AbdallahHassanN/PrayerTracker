package com.example.steamdbmockup.ui.presentation.DetailScreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prayertracker.common.Constants
import com.example.prayertracker.common.Constants.TAG
import com.example.prayertracker.common.Resource
import com.example.prayertracker.model.Prayer
import com.example.prayertracker.usecases.GetPrayerCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgottenPrayersViewModel
@Inject constructor(
    private val getPrayerCountUseCase: GetPrayerCountUseCase
) : ViewModel() {
    val fajr: MutableState<Int?> = mutableStateOf(0)
    val dhuhr: MutableState<Int?> = mutableStateOf(0)
    val asr: MutableState<Int?> = mutableStateOf(0)
    val maghrib: MutableState<Int?> = mutableStateOf(0)
    val isha: MutableState<Int?> = mutableStateOf(0)

    val loading = mutableStateOf(false)
    init {
        getPrayerCount(1, fajr)
        getPrayerCount(2, dhuhr)
        getPrayerCount(3, asr)
        getPrayerCount(4, maghrib)
        getPrayerCount(5, isha)
    }

    private fun getPrayerCount (
        id: Int,
        count: MutableState<Int?>
    ) = viewModelScope.launch {
        loading.value = true
        getPrayerCountUseCase.execute(id = id).catch {
            Log.d(TAG, "Error in VM")
        }.collect { response ->
            getCount(response = response, loading = loading, count = count)
        }
    }

    private fun getCount(
        response: Resource<Int>,
        loading: MutableState<Boolean>,
        count: MutableState<Int?>
    ) {
        when (response) {
            is Resource.Error -> {
                loading.value = false
                Log.d(TAG, "VM Error response")
            }
            is Resource.Loading -> {
                loading.value = true
                Log.d(TAG, "VM Loading")
            }
            is Resource.Success -> {
                count.value = response.data!!
                loading.value = false
            }
        }
    }
}
