package otp.systems.rdldashboard.exstension

import android.view.View

private const val DEBOUNCE: Long = 300L
private var isClickEnabled: Boolean = true
private val enable: () -> Unit = { isClickEnabled = true }

/**
 * Клик-листенер, предотвращающий многократные быстрые клики.
 * После удачного клика, другие клики не срабатывают в течение 300мс
 */
fun View.setOnDebouncedClickListener(action: () -> Unit) {
    this.setOnClickListener { v ->
        if (isClickEnabled) {
            isClickEnabled = false
            v.postDelayed(enable, DEBOUNCE)
            action.invoke()
        }
    }
}




