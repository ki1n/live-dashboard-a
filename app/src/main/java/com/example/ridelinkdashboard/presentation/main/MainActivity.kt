package com.example.ridelinkdashboard.presentation.main

import com.example.ridelinkdashboard.databinding.ActivityMainBinding
import com.example.ridelinkdashboard.domain.entiy.DashBoard
import com.example.ridelinkdashboard.presentation.base.BaseActivity
import com.example.ridelinkdashboard.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override val viewModel by viewModel<MainViewModel>()

    override fun iniView() {

        viewModel.socketLiveData.observe(this@MainActivity) {
            updateUI(it)
        }
    }

    private fun updateUI(dashBoard: DashBoard) {
        binding.performance.setDataProgressPerformance(dashBoard.throttle)
        binding.performance.setDataProgressEngLoad(dashBoard.engineLoad)

      //  binding.tachometer.setValue(dashBoard.tachometer)

        binding.tachometer.setValueSpeed(dashBoard.speed)
        binding.tachometer.setValueGear(dashBoard.gear)
        binding.tachometer.setRmpTachometer(dashBoard.rpm)

        binding.vin.setValue(dashBoard.vin)

        binding.dataIntManP.setHeader(Constants.INT_MAN_P)
        binding.dataIntManP.setValue(dashBoard.intManP)
        binding.dataIntManP.setValueType(Constants.PSI)

        binding.dataAirFlowRate.setHeader(Constants.AIR_FLOW_RATE)
        binding.dataAirFlowRate.setValue(dashBoard.airFlowRate)
        binding.dataAirFlowRate.setValueType(Constants.GR_S)

        binding.dataTemperature.setHeader(Constants.TEMPERATURE)
        binding.dataTemperature.setValue(dashBoard.temperature)
        binding.dataTemperature.setValueType(Constants.DEGREE_CELSIUS)

        binding.dataBarPressure.setHeader(Constants.BAR_PRESSURE)
        binding.dataBarPressure.setValue(dashBoard.pressure)
        binding.dataBarPressure.setValueType(Constants.BAR)
    }
}
