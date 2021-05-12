package com.example.ridelinkdashboard.di

import com.example.ridelinkdashboard.data.socket.SocketRepositoryImpl
import com.example.ridelinkdashboard.domain.socket.SocketRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<SocketRepository> { SocketRepositoryImpl() }
}
