package otp.systems.rdldashboard.di

import org.koin.dsl.module
import otp.systems.rdldashboard.socket.WebSocketHandler

val dataModule = module {

    single { WebSocketHandler() }
}

