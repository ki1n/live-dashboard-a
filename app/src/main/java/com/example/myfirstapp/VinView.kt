package com.example.myfirstapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.myfirstapp.databinding.ViewVinBinding

class VinView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val binding = ViewVinBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        View.inflate(context, R.layout.view_vin, this)
    }
}
