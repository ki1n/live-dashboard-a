package com.example.myfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.util.BasicСonstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewDataIntManP = findViewById<DataView>(R.id.data_int_man_p)
        val viewDataAirFlowRate = findViewById<DataView>(R.id.data_air_flow_rate)
        val viewDataTemperature = findViewById<DataView>(R.id.data_temperature)
        val viewDataBarPressure = findViewById<DataView>(R.id.data_bar_pressure)

        val viewPerformance = findViewById<PerformanceView>(R.id.performance)

        viewPerformance.setDataProgressPerformance(92)
        viewPerformance.setDataProgressEngLoad(56)

        viewDataIntManP.setHeadingData(BasicСonstants.INT_MAN_P)
        viewDataIntManP.setCountLongData(356)
        viewDataIntManP.setTextData(BasicСonstants.PSI)

        viewDataAirFlowRate.setHeadingData(BasicСonstants.AIR_FLOW_RATE)
        viewDataAirFlowRate.setCountLongData(50)
        viewDataAirFlowRate.setTextData(BasicСonstants.GR_S)

        viewDataTemperature.setHeadingData(BasicСonstants.TEMPERATURE)
        viewDataTemperature.setCountLongData(689)
        viewDataTemperature.setTextData(BasicСonstants.DEGREE_CELSIUS)

        viewDataBarPressure.setHeadingData(BasicСonstants.BAR_PRESSURE)
        viewDataBarPressure.setCountDoubleData(10.2564343)
        viewDataBarPressure.setTextData(BasicСonstants.BAR)

    }
}
