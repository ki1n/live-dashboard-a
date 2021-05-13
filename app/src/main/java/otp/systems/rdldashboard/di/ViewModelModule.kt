package otp.systems.rdldashboard.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import otp.systems.rdldashboard.presentation.main.MainViewModel

val viewModelModule = module {

    viewModel { MainViewModel(get(), get()) }
}
