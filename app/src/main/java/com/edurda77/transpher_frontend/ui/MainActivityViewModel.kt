package com.edurda77.transpher_frontend.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.transpher_frontend.retrofit.RetrofitUseCaseImpl
import com.edurda77.transpher_frontend.utils.ADMIN
import com.edurda77.transpher_frontend.utils.NetworkState
import com.edurda77.transpher_frontend.utils.StateMainActivity
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val retrofitUseCaseImpl = RetrofitUseCaseImpl()
    private val _companiesData =
        MutableLiveData<StateMainActivity>(StateMainActivity.Empty)
    val companiesData = _companiesData

    fun getDataForShow(login:String, password:String) {
        viewModelScope.launch {
            try {
                _companiesData.value =  StateMainActivity.Loading
                if (login == ADMIN) {
                    val result = retrofitUseCaseImpl.getDataAdmin(login, password)
                    _companiesData.value =  StateMainActivity.Success(result)
                } else {
                    val result = retrofitUseCaseImpl.getData(login, password)
                    when (result) {
                        is NetworkState.Success -> {
                            _companiesData.value = StateMainActivity.SuccessSingle(result.data)
                        }
                        is NetworkState.Error -> {
                            _companiesData.value = StateMainActivity.Failure(result.response.errorBody().toString())
                        }
                    }

                    //_companiesData.value =  StateMainActivity.SuccessSingle(result)
                }
            } catch (error: Exception) {
                _companiesData.value = StateMainActivity.Failure(error.toString())
            }
        }
    }
}