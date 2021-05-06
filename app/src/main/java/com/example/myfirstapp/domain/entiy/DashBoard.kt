package com.example.myfirstapp.domain.entiy

import com.google.gson.annotations.SerializedName

data class DashBoard(
        @SerializedName("rpm")
        val rpm: Int,
        @SerializedName("speed")
        val speed: Int,
        @SerializedName("gear")
        val gear: Int,
        @SerializedName("throttle")
        val throttle: Int,
        @SerializedName("engineLoad")
        val engineLoad: Int,
        @SerializedName("intManP")
        val intManP: Int,
        @SerializedName("airFlowRate")
        val airFlowRate: Int,
        @SerializedName("temperature")
        val temperature: Int,
        @SerializedName("pressure")
        val pressure: Double,
        @SerializedName("vin")
        val vin: String
)
