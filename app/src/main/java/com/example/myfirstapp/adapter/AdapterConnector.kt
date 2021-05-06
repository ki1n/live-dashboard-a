package com.example.myfirstapp.adapter

import android.content.Context
import com.example.myfirstapp.socket.WebSocketHandler
import com.example.myfirstapp.util.Constants
import org.json.JSONObject

class AdapterConnector(private val context: Context) {
    private val webSocketHandler = WebSocketHandler()

    fun start(value: (String) -> Unit, error: (Exception) -> Unit) {
        webSocketHandler.start(context, Constants.url + Constants.port, onSuccess = {
            try {
                val jsonObject = JSONObject(it)
                value(jsonObject.getString("gyro_leaning_angle"))
            } catch (e: Exception) {
                error(Exception("JSON failed"))
            }
        }, onError = {
            it.printStackTrace()
            error(Exception("Webservice error"))
            webSocketHandler.retryConnection()
        })
    }

    fun stop() {
        webSocketHandler.stop()
    }
}
