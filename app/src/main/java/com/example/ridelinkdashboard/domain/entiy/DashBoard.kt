package com.example.ridelinkdashboard.domain.entiy

import com.google.gson.annotations.SerializedName

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
        val temp_engine_oil: Double?,
        @SerializedName("gyro_leaning_angle")
        val gyro_leaning_angle: Int?,
        @SerializedName("pressure_barometric")
        val pressure_barometric: Int?,
        @SerializedName("vin")
        val vin: String?
)

