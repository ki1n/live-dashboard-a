package com.example.myfirstapp.presentation.custom_view

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

    fun setValue(vin: String) {
        binding.tvValueVin.text = vin
    }
}
