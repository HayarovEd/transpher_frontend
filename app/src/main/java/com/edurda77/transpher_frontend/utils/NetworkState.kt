package com.edurda77.transpher_frontend.utils

import com.edurda77.transpher_frontend.model.ErrorModel
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Response

sealed class NetworkState<out T> {
    data class Success<out T>(val data: T): NetworkState<T>()
    data class Error<T>(val response: Response<T>): NetworkState<T>()
}

fun <T> Response<T>.parseResponse(): NetworkState<T> {
    return if (this.isSuccessful && this.body() != null) {
        val responseBody = this.body()
        NetworkState.Success(responseBody!!)
    } else {
        val jsonObj = JSONObject(this.errorBody()!!.charStream().readText())
        NetworkState.Error(jsonObj.getString("msg"))
    }
}