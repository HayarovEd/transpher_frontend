package com.edurda77.transpher_frontend.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UpdateDataModel (
        @SerializedName("login")
        val transferLogin: String,
        @SerializedName("password")
        val transferPassword: String,
        @SerializedName("data")
        val transferData: Int
        ): Serializable