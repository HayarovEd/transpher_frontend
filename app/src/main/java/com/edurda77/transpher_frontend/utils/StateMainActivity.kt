package com.edurda77.transpher_frontend.utils

import com.edurda77.transpher_frontend.model.LoginData

sealed class StateMainActivity {
    object Loading : StateMainActivity()
    class Failure(val msg:Throwable) : StateMainActivity()
    class Success(val data:List<LoginData>) : StateMainActivity()
    class Success2 (val data:LoginData) : StateMainActivity()
    object Empty : StateMainActivity()
}
