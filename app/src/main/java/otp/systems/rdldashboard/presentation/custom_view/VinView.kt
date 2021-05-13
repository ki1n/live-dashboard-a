package otp.systems.rdldashboard.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import otp.systems.rdldashboard.databinding.ViewVinBinding
import otp.systems.rdldashboard.util.Constants

class VinView @JvmOverloads constructor(
        context: Context,
        private val attrs: AttributeSet? = null,
        private val defStyle: Int = 0) : FrameLayout(context, attrs, defStyle) {

    private val binding = ViewVinBinding.inflate(LayoutInflater.from(context), this, true)

    fun setValue(vin: String?) {
        if (vin == null) {
            binding.tvValueVin.text = Constants.NULL_DATA
        } else {
            binding.tvValueVin.text = vin
        }
    }
}
