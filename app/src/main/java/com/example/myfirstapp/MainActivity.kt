package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.entiy.DashBoard
import com.example.myfirstapp.util.BasicСonstants
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {

    private lateinit var viewDataIntManP: DataView
    private lateinit var viewDataAirFlowRate: DataView
    private lateinit var viewDataTemperature: DataView
    private lateinit var viewDataBarPressure: DataView

    private lateinit var viewPerformance: PerformanceView
    private lateinit var viewTachometer: TachometerView
    private lateinit var viewVin: VinView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewDataIntManP = findViewById(R.id.data_int_man_p)
        viewDataAirFlowRate = findViewById(R.id.data_air_flow_rate)
        viewDataTemperature = findViewById(R.id.data_temperature)
        viewDataBarPressure = findViewById(R.id.data_bar_pressure)

        viewPerformance = findViewById(R.id.performance)
        viewTachometer = findViewById(R.id.tachometer)
        viewVin = findViewById(R.id.vin)

        // TODO: pure java socket
        Thread { wsConnection() }.start()

        // TODO: RideLink WebSocketHandler
//        WebSocketHandler().start(this, "ws://192.168.88.213:9081",
//                onSuccess = { Log.d("WebSocketHandler", it) },
//                onError = { it.printStackTrace() })

    }

    private fun updateUI(dashBoard: DashBoard) {
        viewPerformance.setDataProgressPerformance(dashBoard.throttle)
        viewPerformance.setDataProgressEngLoad(dashBoard.engineLoad)

        viewTachometer.setSpeedCount(dashBoard.speed)
        viewTachometer.setGearCount(dashBoard.gear)
        // TODO anim
        viewTachometer.setRmpTachometer(dashBoard.gear)

        viewVin.setVinData(dashBoard.vin)

        viewDataIntManP.setHeadingData(BasicСonstants.INT_MAN_P)
        viewDataIntManP.setCountLongData(dashBoard.intManP)
        viewDataIntManP.setTextData(BasicСonstants.PSI)

        viewDataAirFlowRate.setHeadingData(BasicСonstants.AIR_FLOW_RATE)
        viewDataAirFlowRate.setCountLongData(dashBoard.airFlowRate)
        viewDataAirFlowRate.setTextData(BasicСonstants.GR_S)

        viewDataTemperature.setHeadingData(BasicСonstants.TEMPERATURE)
        viewDataTemperature.setCountLongData(dashBoard.temperature)
        viewDataTemperature.setTextData(BasicСonstants.DEGREE_CELSIUS)

        viewDataBarPressure.setHeadingData(BasicСonstants.BAR_PRESSURE)
        viewDataBarPressure.setCountDoubleData(dashBoard.pressure)
        viewDataBarPressure.setTextData(BasicСonstants.BAR)
    }

    private fun wsConnection() {
        val hostName = "192.168.88.213"
        val portNumber = 9081

        Socket(hostName, portNumber).use { kkSocket ->
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
        }
    }
}
