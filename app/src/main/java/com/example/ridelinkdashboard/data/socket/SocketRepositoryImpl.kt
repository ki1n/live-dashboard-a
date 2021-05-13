package com.example.ridelinkdashboard.data.socket

import android.content.Context
import com.example.ridelinkdashboard.domain.entiy.DashBoard
import com.example.ridelinkdashboard.domain.socket.SocketRepository
import com.example.ridelinkdashboard.socket.WebSocketHandler
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn

class SocketRepositoryImpl(private val context: Context, private val webSocketHandler: WebSocketHandler) : SocketRepository {

    companion object {
        private const val hostName = "192.168.88.213"
        private const val portNumber = 9080
    }

    @ExperimentalCoroutinesApi
    override suspend fun observeDashboard(): Flow<DashBoard> = callbackFlow {
        webSocketHandler.start(context, "ws://${hostName}:${portNumber}",
                onSuccess = {
                    val dashBoard = Gson().fromJson(it, DashBoard::class.java)
                    sendBlocking(dashBoard)
                }, onError = {
            it.printStackTrace()
            webSocketHandler.retryConnection()
        })
        awaitClose { webSocketHandler.stop() }
    }.flowOn(Dispatchers.IO)
}




