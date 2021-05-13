package otp.systems.rdldashboard.presentation.main

import org.koin.androidx.viewmodel.ext.android.viewModel
import otp.systems.rdldashboard.R
import otp.systems.rdldashboard.databinding.ActivityMainBinding
import otp.systems.rdldashboard.domain.entiy.DashBoard
import otp.systems.rdldashboard.exstension.setOnDebouncedClickListener
import otp.systems.rdldashboard.presentation.base.BaseActivity
import otp.systems.rdldashboard.util.Constants

class MainActivity : BaseActivity() {
    override val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override val viewModel by viewModel<MainViewModel>()

    private var isSocketRunning = false

    override fun iniView() {

        viewModel.socketLiveData.observe(this@MainActivity) {
            updateUI(it)
        }

        viewModel.webSocketRunning.observe(this@MainActivity) {
            isSocketRunning = it
            if (isSocketRunning) {
                binding.tvDisconnectConnect.text = Constants.DISCONNECT
            } else {
                binding.tvDisconnectConnect.text = Constants.CONNECT
            }
        }

        viewModel.webSocketConnected.observe(this@MainActivity) {
            if (it) {
                binding.tvSocketStatusBoolean.setBackgroundResource(R.drawable.background_socket_status_true)
            } else {
                binding.tvSocketStatusBoolean.setBackgroundResource(R.drawable.background_socket_status_false)
            }
        }

        binding.tvDisconnectConnect.setOnDebouncedClickListener {
            if (isSocketRunning) {
                viewModel.disconnected()
            } else {
                viewModel.connect()
            }
        }
    }

    private fun updateUI(dashBoard: DashBoard) {
        with(binding) {
            performance.setDataProgressPerformance(dashBoard.throttle_position)
            performance.setDataProgressEngLoad(dashBoard.engine_load)

            tachometer.setValueSpeed(dashBoard.speed)
            tachometer.setValueGear(dashBoard.gear)
            tachometer.setRmpTachometer(dashBoard.rpm)

            tachometer.setValueSpeed(dashBoard.speed)
            tachometer.setValueGear(dashBoard.gear)
            tachometer.setRmpTachometer(dashBoard.rpm)

            tachometer.setValueSpeed(dashBoard.speed)
            tachometer.setValueGear(dashBoard.gear)
            tachometer.setRmpTachometer(dashBoard.rpm)

            vin.setValue(dashBoard.vin)

            dataIntManP.setHeader(Constants.TEMP_COOLANT)
            dataIntManP.setValue(dashBoard.temp_coolant_engine)
            dataIntManP.setValueType(Constants.DEGREE_CELSIUS)

            dataAirFlowRate.setHeader(Constants.TEMP_ENGINE_OIL)
            dataAirFlowRate.setValue(dashBoard.temp_engine_oil)
            dataAirFlowRate.setValueType(Constants.DEGREE_CELSIUS)

            dataTemperature.setHeader(Constants.GYRO)
            dataTemperature.setValue(dashBoard.gyro_leaning_angle)
            dataTemperature.setValueType(Constants.DEGREE)

            dataBarPressure.setHeader(Constants.BAR_PRESSURE)
            dataBarPressure.setValue(dashBoard.pressure_barometric)
            dataBarPressure.setValueType(Constants.BAR)
        }
    }
}
