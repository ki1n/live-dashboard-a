package otp.systems.rdldashboard

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import otp.systems.rdldashboard.di.dataModule
import otp.systems.rdldashboard.di.repositoryModule
import otp.systems.rdldashboard.di.viewModelModule

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
