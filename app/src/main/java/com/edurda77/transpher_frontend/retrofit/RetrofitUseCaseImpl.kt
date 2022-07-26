package com.edurda77.transpher_frontend.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://tranfer-backend.herokuapp.com"

class RetrofitUseCaseImpl : RetrofitUseCase {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    private var api: ApiService = retrofit.create(ApiService::class.java)
    override suspend fun getData(login: String, password: String) = api.getLogin(login, password)
    override suspend fun getDataAdmin(login: String, password: String) =
        api.getLoginAdmin(login, password)


}