package com.example.myfirstapp.presentation.main

import androidx.lifecycle.MutableLiveData
import com.example.myfirstapp.domain.entiy.DashBoard
import com.example.myfirstapp.domain.socket.SocketRepository
import com.example.myfirstapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn

class MainViewModel(private val socketRepository: SocketRepository) : BaseViewModel() {

    val socketLiveData = MutableLiveData<DashBoard>()

    suspend fun observeDashboard() {
        socketRepository.observeDashboard()
                .flowOn(Dispatchers.Main)
                .collect {
                    socketLiveData.value = it
                }
    }
}
