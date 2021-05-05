package com.example.myfirstapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewTachometerBinding

class TachometerView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val fadeInAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.fadein) // угасать
    private val fadeOutAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.fadeout) // исчезать

    private val binding = ViewTachometerBinding.inflate(LayoutInflater.from(context), this, true)

    fun setSpeedCount(speed: Int) {
        binding.tvSpeedCount.text = speed.toString()
    }

    fun setGearCount(gear: Int) {
        binding.tvGearCount.text = gear.toString()
    }

    fun setRmpTachometer(rmp: Int) {
        when (rmp) {
            0 -> {
                binding.tvTachometerItem1.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem2.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem3.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem4.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem5.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            1 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem3.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem4.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem5.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            2 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem4.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem5.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            3 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem5.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            4 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            5 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            6 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeInAnimation)
                binding.tvTachometerItem7.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            7 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeInAnimation)
                binding.tvTachometerItem7.startAnimation(fadeInAnimation)
                binding.tvTachometerItem8.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            8 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeInAnimation)
                binding.tvTachometerItem7.startAnimation(fadeInAnimation)
                binding.tvTachometerItem8.startAnimation(fadeInAnimation)
                binding.tvTachometerItem9.startAnimation(fadeOutAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            9 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeInAnimation)
                binding.tvTachometerItem7.startAnimation(fadeInAnimation)
                binding.tvTachometerItem8.startAnimation(fadeInAnimation)
                binding.tvTachometerItem9.startAnimation(fadeInAnimation)
                binding.tvTachometerItem10.startAnimation(fadeOutAnimation)
            }
            10 -> {
                binding.tvTachometerItem1.startAnimation(fadeInAnimation)
                binding.tvTachometerItem2.startAnimation(fadeInAnimation)
                binding.tvTachometerItem3.startAnimation(fadeInAnimation)
                binding.tvTachometerItem4.startAnimation(fadeInAnimation)
                binding.tvTachometerItem5.startAnimation(fadeInAnimation)
                binding.tvTachometerItem6.startAnimation(fadeInAnimation)
                binding.tvTachometerItem7.startAnimation(fadeInAnimation)
                binding.tvTachometerItem8.startAnimation(fadeInAnimation)
                binding.tvTachometerItem9.startAnimation(fadeInAnimation)
                binding.tvTachometerItem10.startAnimation(fadeInAnimation)
            }
        }
    }

}
