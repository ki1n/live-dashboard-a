package com.example.myfirstapp.domain.socket

import com.example.myfirstapp.domain.entiy.DashBoard
import kotlinx.coroutines.flow.Flow

interface SocketRepository {

    suspend fun observeDashboard(): Flow<DashBoard>
}
