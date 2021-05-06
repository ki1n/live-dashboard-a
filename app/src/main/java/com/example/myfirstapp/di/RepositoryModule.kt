package com.example.myfirstapp.di

import com.example.myfirstapp.data.socket.SocketRepositoryImpl
import com.example.myfirstapp.domain.socket.SocketRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<SocketRepository> { SocketRepositoryImpl() }
}
