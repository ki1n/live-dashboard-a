package com.example.ridelinkdashboard.domain.entiy

import com.google.gson.annotations.SerializedName

//data class DashBoard(
//       val tachometer: Tachometer,
//       val engine: Engine,
//       val intManP: IntManP,
//       val airFlow: AirFlow,
//        @SerializedName("temperature")
//        val temperature: Int?,
//        @SerializedName("pressure")
//        val pressure: Double?,
//        @SerializedName("vin")
//        val vin: String?
//) {
//        data class Tachometer(
//                @SerializedName("rpm")
//                val rpm: Int?,
//                @SerializedName("speed")
//                val speed: Int?,
//                @SerializedName("gear")
//                val gear: Int?
//        )
//
//        data class Engine(
//                @SerializedName("throttle")
//                val throttle: Int?,
//                @SerializedName("engineLoad")
//                val engineLoad: Int?
//        )
//
//        data class IntManP(
//                @SerializedName("intManP")
//                val intManP: Int?,
//                val header: String = Constants.INT_MAN_P,
//                val valueType: String = Constants.PSI
//                )
//
//        data class AirFlow(
//                @SerializedName("airFlowRate")
//                val airFlowRate: Int?,
//                val header: String = Constants.AIR_FLOW_RATE,
//                val valueType: String = Constants.GR_S
//        )
//}
//
//{
//        "acc_x": -0.6999806770744976,
//        "acc_y": 0.07623741401525172,
//        "acc_z": -0.4283081149112328,
//        "adp_timestamp": 1620811738311,
//        "speed": 0,
//        "rpm": 3241,
//        "gyro_leaning_angle": 130,
//        "internal_battery_voltage": 6.0670046646674685,
//        "power_battery_voltage": 4.836665837172286,
//        "throttle_position": 33,
//        "engine_load": 78,
//        "temp_coolant_engine": 77,
//        "temp_engine_oil": 3,
//        "pressure_barometric": 96,
//        "vin": "R1D3L1NKS1MUL4T0R"
//}

data class DashBoard(
        @SerializedName("rpm")
        val rpm: Int?,
        @SerializedName("speed")
        val speed: Int?,
        @SerializedName("gear")
        val gear: Int?,
        @SerializedName("throttle_position")
        val throttle_position: Int?,
        @SerializedName("engine_load")
        val engine_load: Int?,
        @SerializedName("temp_coolant_engine")
        val temp_coolant_engine: Double?,
        @SerializedName("temp_engine_oil")
        val temp_engine_oil: Int?,
        @SerializedName("gyro_leaning_angle")
        val gyro_leaning_angle: Int?,
        @SerializedName("pressure_barometric")
        val pressure_barometric: Int?,
        @SerializedName("vin")
        val vin: String?
)

