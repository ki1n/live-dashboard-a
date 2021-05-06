package com.example.myfirstapp.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewPerformanceBinding

class PerformanceView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val binding = ViewPerformanceBinding.inflate(LayoutInflater.from(context), this, true)

    fun setDataProgressPerformance(progress: Int) {
        binding.progressBarThrotle.progress = progress
    }

    fun setDataProgressEngLoad(progress: Int) {
        binding.progressBarEngLoad.progress = progress
    }
}
