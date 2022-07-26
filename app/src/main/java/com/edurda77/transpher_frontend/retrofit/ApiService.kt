package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    suspend fun getLogin(
        @Query("login") login: String,
        @Query("password") password: String,
    ): LoginData

    @POST("/login")
    suspend fun getLoginAdmin(
        @Query("login") login: String,
        @Query("password") password: String,
    ): List<LoginData>
}