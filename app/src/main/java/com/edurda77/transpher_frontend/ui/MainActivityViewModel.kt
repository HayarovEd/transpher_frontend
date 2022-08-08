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
    private val _commonData =
        MutableLiveData<StateMainActivity>(StateMainActivity.Empty)
    val commonData = _commonData

    fun getDataForShow(login:String, password:String) {
        viewModelScope.launch {
            try {
                _commonData.value =  StateMainActivity.Loading
                if (login == ADMIN) {
                    when (val result = retrofitUseCaseImpl.getDataAdmin(login, password)) {
                        is NetworkState.Success -> {
                            _commonData.value =  StateMainActivity.Success(result.data)
                        }
                        is NetworkState.Error -> {
                            _commonData.value = StateMainActivity.Failure(result.message)
                        }
                    }
                } else {
                    when (val result = retrofitUseCaseImpl.getData(login, password)) {
                        is NetworkState.Success -> {
                            _commonData.value =  StateMainActivity.SuccessSingle(result.data)
                        }
                        is NetworkState.Error -> {
                            _commonData.value = StateMainActivity.Failure(result.message)
                        }
                    }

                }
            } catch (error: Exception) {
                _commonData.value = StateMainActivity.Failure(error.toString())
            }
        }
    }
}