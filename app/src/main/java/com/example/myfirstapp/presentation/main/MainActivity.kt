package com.example.myfirstapp.presentation.main

import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.myfirstapp.R
import com.example.myfirstapp.data.socket.SocketRepositoryImpl
import com.example.myfirstapp.domain.entiy.DashBoard
import com.example.myfirstapp.domain.socket.SocketRepository
import com.example.myfirstapp.presentation.base.BaseActivity
import com.example.myfirstapp.util.Constants
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override var layoutId: Int = R.layout.activity_main

    override val viewModel by viewModel<MainViewModel>()


    override fun iniView() {
        //  Thread { wsConnection() }.start()
        //  wsConnection()
        lifecycleScope.launchWhenCreated {
            val d = viewModel.socketLiveData
            updateUI(d)
        }
    }

    private val socketRepository: SocketRepository = SocketRepositoryImpl()

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

    private fun wsConnection() {
        val hostName = "192.168.88.213"
        val portNumber = 9081
        lifecycleScope.launchWhenStarted {
            socketRepository.observeDashboard()
                    .flowOn(Dispatchers.Main)
                    /*.onEach {
                        updateUI(it)
                    }*/
                    .collect { dashBoard ->
                        Log.d("wsConnection", dashBoard.toString())
//                        updateUI(dashBoard)
                    }
        }

        /*   Socket(hostName, portNumber).use { kkSocket ->
               PrintWriter(kkSocket.getOutputStream(), true).use { out ->
                   BufferedReader(
                           InputStreamReader(kkSocket.getInputStream())).use { `in` ->
                       out.println("started")
                       var fromServer: String
                       while (`in`.readLine().also { fromServer = it } != null) {
                           val dashBoard = Gson().fromJson(fromServer, DashBoard::class.java)

                           runOnUiThread { updateUI(dashBoard) }
                           Log.d("wsConnection", dashBoard.toString())

                           out.println("readed");
                       }
                   }
               }
           }*/
    }
}
