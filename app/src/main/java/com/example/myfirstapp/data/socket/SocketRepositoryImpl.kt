package com.example.myfirstapp.data.socket

import android.util.Log
import com.example.myfirstapp.domain.entiy.DashBoard
import com.example.myfirstapp.domain.socket.SocketRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class SocketRepositoryImpl : SocketRepository {

    companion object {
        private const val hostName = "192.168.88.213"
        private const val portNumber = 9081
    }

    override suspend fun observeDashboard(): Flow<DashBoard> = flow {
        Socket(hostName, portNumber).use { kkSocket ->
            java.io.PrintWriter(kkSocket.getOutputStream(), true).use { out ->
                BufferedReader(
                        InputStreamReader(kkSocket.getInputStream())).use { `in` ->
                    out.println("started")
                    var fromServer: String
                    while (`in`.readLine().also { fromServer = it } != null) {
                        val dashBoard = Gson().fromJson(fromServer, DashBoard::class.java)
                        Log.d("wsConnection", dashBoard.toString())
                        out.println("readed")
                        emit(dashBoard)
                    }
                }
            }
        }
    }
            .catch { e -> throw Exception(e.localizedMessage) }
            .flowOn(Dispatchers.Default)

    //channel
//    private val dashboardChannel = Channel<DashBoard>(2)
//
//    private fun observeDash() {
//        Socket(hostName, portNumber).use { kkSocket ->
//            PrintWriter(kkSocket.getOutputStream(), true).use { out ->
//                BufferedReader(
//                        InputStreamReader(kkSocket.getInputStream())).use { `in` ->
//                    out.println("started")
//                    var fromServer: String
//                    while (`in`.readLine().also { fromServer = it } != null) {
//                        val dashBoard = Gson().fromJson(fromServer, DashBoard::class.java)
//                        dashboardChannel.sendBlocking(dashBoard)
//                    }
//                }
//            }
//        }
//    }
//
//    override suspend fun observeDashboard(): Flow<DashBoard> {
//        Thread {
//            observeDash()
//        }.start()
//        return dashboardChannel.consumeAsFlow()
//    }
}
