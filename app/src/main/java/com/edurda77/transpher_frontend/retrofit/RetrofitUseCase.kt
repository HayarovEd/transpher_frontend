package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData

interface RetrofitUseCase {
    suspend fun getData(login: String, password:String): LoginData
    suspend fun getDataAdmin(login: String, password:String): List<LoginData>
}