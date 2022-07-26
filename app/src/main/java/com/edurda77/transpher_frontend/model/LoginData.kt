package com.edurda77.transpher_frontend.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginData(
    @SerializedName("login")
    val loginUser: String,
    @SerializedName("password")
    val loginPassword: String,
    @SerializedName("lastData")
    val lastData: Int,
    @SerializedName("currentData")
    val currentData: Int,
    @SerializedName("updateDate")
    val updateDate: String
) : Serializable
