package com.example.ridelinkdashboard.di

import com.example.ridelinkdashboard.socket.WebSocketHandler
import org.koin.dsl.module

val dataModule = module {

    single { WebSocketHandler() }
}

