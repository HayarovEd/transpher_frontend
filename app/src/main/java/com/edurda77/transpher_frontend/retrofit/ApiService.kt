package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.model.SendLoginModel
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    suspend fun getLogin(
        @Body sendLoginModel: SendLoginModel
    ): LoginData

    @POST("/login")
    suspend fun getLoginAdmin(
        @Body sendLoginModel: SendLoginModel
    ): List<LoginData>
}