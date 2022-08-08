package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.utils.NetworkState

interface RetrofitUseCase {
    suspend fun getData(login: String, password:String): NetworkState<LoginData>
    suspend fun getDataAdmin(login: String, password:String): NetworkState<List<LoginData>>
}