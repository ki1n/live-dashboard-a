package com.example.ridelinkdashboard.data.socket

import android.util.Log
import com.example.ridelinkdashboard.domain.entiy.DashBoard
import com.example.ridelinkdashboard.domain.socket.SocketRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
        private const val postNumberNew = 9008
    }

//    override suspend fun observeDashboard(): Flow<DashBoard> = flow {
//        emit(DashBoard(
//                rpm = 10000,
//                speed = null,
//                gear = null,
//                throttle = 87,
//                engineLoad = 11,
//                intManP = null,
//                airFlowRate = null,
//                temperature = null,
//                pressure = null,
//                vin = null))
//    }
//            .catch { e -> throw Exception(e.localizedMessage) }
//            .flowOn(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override suspend fun observeDashboard(): Flow<DashBoard> = flow {
        Socket(hostName, portNumber).use { kkSocket ->
            if (kkSocket.isConnected) {
                java.io.PrintWriter(kkSocket.getOutputStream(), true).use { out ->
                    BufferedReader(
                            InputStreamReader(kkSocket.getInputStream())).use { `in` ->
                        out.println("started")
                        var fromServer: String
                        while (`in`.readLine().also { fromServer = it } != null) {
                            val dashBoard = Gson().fromJson(fromServer, DashBoard::class.java)
                            emit(dashBoard)

                            Log.d("wsConnection", dashBoard.toString())
                            out.println("readed")
                        }
                    }
                }
            } else {
                emit(DashBoard(
                        rpm = null,
                        speed = null,
                        gear = null,
                        throttle_position = null,
                        engine_load = null,
                        temp_coolant_engine = null,
                        temp_engine_oil = null,
                        gyro_leaning_angle = null,
                        pressure_barometric = null,
                        vin = null))
            }
        }
    }
            .catch { e -> throw Exception(e.localizedMessage) }
            .flowOn(Dispatchers.IO)
}




