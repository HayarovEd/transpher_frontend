package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.model.SendLoginModel
import com.edurda77.transpher_frontend.model.UpdateDataModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/login")
    suspend fun getLogin(
        @Body sendLoginModel: SendLoginModel
    ): Response<LoginData>

    @POST("/login")
    suspend fun getLoginAdmin(
        @Body sendLoginModel: SendLoginModel
    ): Response<List<LoginData>>

    @POST("/updatedata")
    suspend fun transpherData (
        @Body updateDataModel: UpdateDataModel
    ) : Response<String>
}