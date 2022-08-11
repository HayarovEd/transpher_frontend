package com.edurda77.transpher_frontend.utils

sealed class StateWorkActivity {
    object Loading : StateWorkActivity()
    class Failure(val msg:String) : StateWorkActivity()
    class Success(val data:String) : StateWorkActivity()
    object Empty : StateWorkActivity()
}
