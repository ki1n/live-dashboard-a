package com.example.ridelinkdashboard

import android.app.Application
import com.example.ridelinkdashboard.di.dataModule
import com.example.ridelinkdashboard.di.repositoryModule
import com.example.ridelinkdashboard.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LiveDashboard : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            this.modules(
                    listOf(
                            dataModule,
                            repositoryModule,
                            viewModelModule,
                    )
            )
            this.androidContext(this@LiveDashboard)
        }
    }
}
