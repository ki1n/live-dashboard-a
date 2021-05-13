package com.example.ridelinkdashboard.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.ridelinkdashboard.databinding.ViewTachometerBinding
import com.example.ridelinkdashboard.exstension.rmpFloor
import com.example.ridelinkdashboard.util.Constants

class TachometerView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    companion object {
        private const val NO_LAST_RMP = -1
    }

    private val binding = ViewTachometerBinding.inflate(LayoutInflater.from(context), this, true)

    private val tachometerItems by lazy {
        listOf(
                binding.tvTachometerItem1,
                binding.tvTachometerItem2,
                binding.tvTachometerItem3,
                binding.tvTachometerItem4,
                binding.tvTachometerItem5,
                binding.tvTachometerItem6,
                binding.tvTachometerItem7,
                binding.tvTachometerItem8,
                binding.tvTachometerItem9,
                binding.tvTachometerItem10
        )
    }

    private var lastRmp: Int = NO_LAST_RMP

    fun setValueSpeed(speed: Int?) {
        if (speed == null) {
            binding.tvValueSpeed.text = Constants.NULL_DATA
        } else {
            binding.tvValueSpeed.text = speed.toString()
        }
    }

    fun setValueGear(gear: Int?) {
        if (gear == null) {
            binding.tvValueGear.text = Constants.NULL_DATA
        } else {
            binding.tvValueGear.text = gear.toString()
        }
    }

    fun setRmpTachometer(rmp: Int?) {
        if (rmp == null) {
            tachometerItems.forEach {
                it.visibility = INVISIBLE
            }
        }
        if (rmp != null && rmp.rmpFloor() != lastRmp) {
            tachometerItems.take(rmp.rmpFloor())
                    .forEach {
                        it.visibility = View.VISIBLE
                    }
            tachometerItems.drop(rmp.rmpFloor())
                    .forEach {
                        it.visibility = View.INVISIBLE
                    }
            lastRmp = rmp.rmpFloor()
        }
    }
}
