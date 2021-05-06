package com.example.myfirstapp

import android.app.Application
import com.example.myfirstapp.di.repositoryModule
import com.example.myfirstapp.di.viewModelModule
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
                            repositoryModule,
                            viewModelModule,
                    )
            )
            this.androidContext(this@LiveDashboard)
        }
    }
}
