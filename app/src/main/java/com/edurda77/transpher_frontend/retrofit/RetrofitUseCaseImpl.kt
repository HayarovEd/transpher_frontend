package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.model.SendLoginModel
import com.edurda77.transpher_frontend.utils.NetworkState
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://tranfer-backend.herokuapp.com"

class RetrofitUseCaseImpl : RetrofitUseCase {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    private var api: ApiService = retrofit.create(ApiService::class.java)
    override suspend fun getData(login: String, password: String): NetworkState<LoginData> {
        val sendData = SendLoginModel(
            loginUser = login,
            loginPassword = password
        )
        val response = api.getLogin(sendData)
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }
    override suspend fun getDataAdmin(login: String, password: String) : List<LoginData> {
        val sendData = SendLoginModel(
            loginUser = login,
            loginPassword = password
        )
        return api.getLoginAdmin(sendData)
    }


}