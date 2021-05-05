package com.example.myfirstapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewVinBinding

class VinView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val binding = ViewVinBinding.inflate(LayoutInflater.from(context), this, true)

    fun setVinData(vin: String) {
        binding.tvVinCount.text = vin
    }
}
