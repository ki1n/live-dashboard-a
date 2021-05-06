package com.example.myfirstapp.socket

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import okhttp3.*
import okio.ByteString

class WebSocketHandler {

  private var okHttpClient: OkHttpClient? = null
  private var webSocket: WebSocket? = null

  private var handler: Handler? = null
  private var context: Context? = null
  private var url: String? = null

  var isRunning: Boolean = false
    private set

  private var onSuccess: ((String) -> Unit)? = null
  private var onError: ((Throwable) -> Unit)? = null

  fun start(context: Context, url: String, onSuccess: (String) -> Unit, onError: (Throwable) -> Unit) {
    this.onSuccess = onSuccess
    this.onError = onError
    isRunning = true
    startWebSocket(context, url)
  }

  fun stop() {
    stopWebSocket()
    this.onSuccess = null
    this.onError = null
    isRunning = false
  }

  fun retryConnection() {
    if (handler == null) {
      handler = Handler(Looper.getMainLooper())
    }

    if (!isRunning) handler?.postDelayed(retryConnectionRunnable, 5000L)
  }

  private val retryConnectionRunnable = Runnable {
    if (context != null && url != null) {
      startWebSocket(context!!, url!!)
    }
  }

  private fun startWebSocket(context: Context, url: String) {
    if (onSuccess != null && onError != null) {
      val reqBuilder = NetworkRequest.Builder()
      reqBuilder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);

      val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      connectivityManager.requestNetwork(reqBuilder.build(), object : ConnectivityManager.NetworkCallback() {
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onAvailable(network: Network) {
          super.onAvailable(network)
          if (onSuccess != null && onError != null) {
            okHttpClient = OkHttpClient.Builder()
                .socketFactory(network.socketFactory)
                //.dns { network.getAllByName(it).toList() }
                .build().also {
                  val request = Request.Builder().url(url).build()
                  val listener = RidelinkWebSocketListener(isRunning, onSuccess!!, onError!!)
                  webSocket = it.newWebSocket(request, listener)
                }
          }
        }
      })
    } else {
      throw  IllegalStateException("Blocks are null")
    }
  }

  private fun stopWebSocket() {
    webSocket?.also {
      it.cancel()
    }
    webSocket = null
    okHttpClient?.dispatcher?.executorService?.shutdown()
    handler?.removeCallbacks(retryConnectionRunnable)
    handler = null
  }

  private class RidelinkWebSocketListener(var isRunning: Boolean, private val onSuccess: (String) -> Unit, private val onError: (Throwable) -> Unit) : WebSocketListener() {
    override fun onOpen(webSocket: WebSocket, response: Response) {
      isRunning = true
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
      onSuccess(text)
    }

    override fun onMessage(webSocket: WebSocket, bytes: ByteString) {

    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {}

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
      isRunning = false
      onError(t)
    }
  }
}
