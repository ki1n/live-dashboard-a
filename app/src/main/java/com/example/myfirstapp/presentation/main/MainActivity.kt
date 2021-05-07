package com.example.myfirstapp.presentation.main

import com.example.myfirstapp.R
import com.example.myfirstapp.domain.entiy.DashBoard
import com.example.myfirstapp.presentation.base.BaseActivity
import com.example.myfirstapp.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override var layoutId: Int = R.layout.activity_main

    override val viewModel by viewModel<MainViewModel>()

    override fun iniView() {
        viewModel.socketLiveData.observe(this@MainActivity) {
            updateUI(it)
        }
    }

    private fun updateUI(dashBoard: DashBoard) {
        performance.setDataProgressPerformance(dashBoard.throttle)
        performance.setDataProgressEngLoad(dashBoard.engineLoad)

        tachometer.setValueSpeed(dashBoard.speed)
        tachometer.setValueGear(dashBoard.gear)
        tachometer.setRmpTachometer(dashBoard.gear)

        vin.setValue(dashBoard.vin)

        data_int_man_p.setHeader(Constants.INT_MAN_P)
        data_int_man_p.setValue(dashBoard.intManP)
        data_int_man_p.setValueType(Constants.PSI)

        data_air_flow_rate.setHeader(Constants.AIR_FLOW_RATE)
        data_air_flow_rate.setValue(dashBoard.airFlowRate)
        data_air_flow_rate.setValueType(Constants.GR_S)

        data_temperature.setHeader(Constants.TEMPERATURE)
        data_temperature.setValue(dashBoard.temperature)
        data_temperature.setValueType(Constants.DEGREE_CELSIUS)

        data_bar_pressure.setHeader(Constants.BAR_PRESSURE)
        data_bar_pressure.setValue(dashBoard.pressure)
        data_bar_pressure.setValueType(Constants.BAR)
    }
}
