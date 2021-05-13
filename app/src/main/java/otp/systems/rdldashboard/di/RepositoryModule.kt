package otp.systems.rdldashboard.di

import org.koin.dsl.module
import otp.systems.rdldashboard.data.socket.SocketRepositoryImpl
import otp.systems.rdldashboard.domain.socket.SocketRepository

val repositoryModule = module {

    single<SocketRepository> { SocketRepositoryImpl(get(), get()) }
}
