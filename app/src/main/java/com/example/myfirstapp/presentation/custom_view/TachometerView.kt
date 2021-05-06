package com.example.myfirstapp.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewTachometerBinding

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
                binding.tvTachometerItem10,
        )
    }

    private var lastRmp: Int = NO_LAST_RMP

    fun setValueSpeed(speed: Int) {
        binding.tvValueSpeed.text = speed.toString()
    }

    fun setValueGear(gear: Int) {
        binding.tvValueGear.text = gear.toString()
    }

    fun setRmpTachometer(rmp: Int) {
        if (rmp != lastRmp) {
            tachometerItems.take(rmp)
                    .forEach {
                        it.visibility = View.VISIBLE
                    }

            tachometerItems.drop(rmp)
                    .forEach {
                        it.visibility = View.INVISIBLE
                    }
            lastRmp = rmp
        }
    }
}
