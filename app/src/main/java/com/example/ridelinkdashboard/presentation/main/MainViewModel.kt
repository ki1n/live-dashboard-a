package com.example.ridelinkdashboard.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ridelinkdashboard.domain.entiy.DashBoard
import com.example.ridelinkdashboard.domain.socket.SocketRepository
import com.example.ridelinkdashboard.presentation.base.BaseViewModel
import com.example.ridelinkdashboard.socket.WebSocketHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(
        private val socketRepository: SocketRepository,
        private val webSocketHandler: WebSocketHandler,
) : BaseViewModel() {

    val socketLiveData = MutableLiveData<DashBoard>()
    val webSocketRunning = MutableLiveData<Boolean>()
    val webSocketConnected = MutableLiveData<Boolean>()

    init {
        connect()
    }

    fun disconnected() {
        webSocketHandler.stop()
        webSocketRunning.value = false
        webSocketConnected.value = false
    }

    fun connect() {
        viewModelScope.launch {
            observeDashboard()
        }
        webSocketRunning.value = true
    }

    private suspend fun observeDashboard() {
        socketRepository.observeDashboard()
                .flowOn(Dispatchers.Main)
                .catch {
                    webSocketConnected.value = false
                }
                .collect {
                    socketLiveData.value = it
                    webSocketConnected.value = true
                }
    }
}
