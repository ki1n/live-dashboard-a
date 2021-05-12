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
        binding.performance.setDataProgressPerformance(dashBoard.throttle_position)
        binding.performance.setDataProgressEngLoad(dashBoard.engine_load)

      //  binding.tachometer.setValue(dashBoard.tachometer)

        binding.tachometer.setValueSpeed(dashBoard.speed)
        binding.tachometer.setValueGear(dashBoard.gear)
        binding.tachometer.setRmpTachometer(dashBoard.rpm)

        binding.vin.setValue(dashBoard.vin)

        binding.dataIntManP.setHeader(Constants.TEMP_COOLANT)
        binding.dataIntManP.setValue(dashBoard.temp_coolant_engine)
        binding.dataIntManP.setValueType(Constants.DEGREE_CELSIUS)

        binding.dataAirFlowRate.setHeader(Constants.TEMP_ENGINE_OIL)
        binding.dataAirFlowRate.setValue(dashBoard.temp_engine_oil)
        binding.dataAirFlowRate.setValueType(Constants.DEGREE_CELSIUS)

        binding.dataTemperature.setHeader(Constants.GYRO)
        binding.dataTemperature.setValue(dashBoard.gyro_leaning_angle)
        binding.dataTemperature.setValueType(Constants.DEGREE)

        binding.dataBarPressure.setHeader(Constants.BAR_PRESSURE)
        binding.dataBarPressure.setValue(dashBoard.pressure_barometric)
        binding.dataBarPressure.setValueType(Constants.BAR)
    }
}
