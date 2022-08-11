package com.edurda77.transpher_frontend.retrofit

import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.model.SendLoginModel
import com.edurda77.transpher_frontend.model.UpdateDataModel
import com.edurda77.transpher_frontend.utils.NetworkState
import com.edurda77.transpher_frontend.utils.parseResponse
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

        val response = api.getLogin(initSendData(login, password))
        return response.parseResponse()
    }

    override suspend fun getDataAdmin(
        login: String,
        password: String
    ): NetworkState<List<LoginData>> {
        val response = api.getLoginAdmin(initSendData(login, password))
        return response.parseResponse()
    }

    override suspend fun sendUpdateData(updateDataModel: UpdateDataModel): NetworkState<String> {
        return api.transpherData(updateDataModel).parseResponse()
    }

    private fun initSendData(login: String, password: String) = SendLoginModel(
        loginUser = login,
        loginPassword = password
    )


}