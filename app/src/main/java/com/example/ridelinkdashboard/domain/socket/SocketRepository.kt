package com.example.ridelinkdashboard.domain.socket

import com.example.ridelinkdashboard.domain.entiy.DashBoard
import kotlinx.coroutines.flow.Flow

interface SocketRepository {

    suspend fun observeDashboard(): Flow<DashBoard>
}
