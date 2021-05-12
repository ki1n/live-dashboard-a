package com.example.ridelinkdashboard.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ridelinkdashboard.domain.entiy.DashBoard
import com.example.ridelinkdashboard.domain.socket.SocketRepository
import com.example.ridelinkdashboard.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(private val socketRepository: SocketRepository) : BaseViewModel() {

    init {
        viewModelScope.launch {
            observeDashboard()
        }
    }

    val socketLiveData = MutableLiveData<DashBoard>()

    private suspend fun observeDashboard() {
        isInProgress.value = true
        socketRepository.observeDashboard()
                .flowOn(Dispatchers.Main)
                .catch { postMessage(it.localizedMessage) }
                .collect {
                    socketLiveData.value = it
                    isInProgress.value = false
                }
    }
}
