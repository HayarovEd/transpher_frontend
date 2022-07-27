package com.edurda77.transpher_frontend.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SendLoginModel(
    @SerializedName("login")
    val loginUser: String,
    @SerializedName("password")
    val loginPassword: String
) : Serializable
