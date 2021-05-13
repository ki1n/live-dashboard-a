package otp.systems.rdldashboard.domain.socket

import kotlinx.coroutines.flow.Flow
import otp.systems.rdldashboard.domain.entiy.DashBoard

interface SocketRepository {

    suspend fun observeDashboard(): Flow<DashBoard>
}
