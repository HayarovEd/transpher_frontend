package com.edurda77.transpher_frontend.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.transpher_frontend.model.UpdateDataModel
import com.edurda77.transpher_frontend.retrofit.RetrofitUseCaseImpl
import com.edurda77.transpher_frontend.utils.NetworkState
import com.edurda77.transpher_frontend.utils.StateWorkActivity
import kotlinx.coroutines.launch

class WorkActivityViewModel : ViewModel() {
    private val retrofitUseCaseImpl = RetrofitUseCaseImpl()
    private val _commonData =
        MutableLiveData<StateWorkActivity>(StateWorkActivity.Empty)
    val commonData = _commonData
    fun UpdateData(updateDataModel: UpdateDataModel) {
        viewModelScope.launch {
            try {
                _commonData.value = StateWorkActivity.Loading
                when (val result =
                    retrofitUseCaseImpl.sendUpdateData(updateDataModel)) {
                    is NetworkState.Success -> {
                        _commonData.value = StateWorkActivity.Success(result.data)
                    }
                    is NetworkState.Error -> {
                        _commonData.value = StateWorkActivity.Failure(result.message)
                    }
                }
            } catch (error: Exception) {
                _commonData.value = StateWorkActivity.Failure(error.toString())
            }
        }
    }
}