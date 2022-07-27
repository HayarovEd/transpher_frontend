package com.edurda77.transpher_frontend.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.transpher_frontend.databinding.ActivityMainBinding
import com.edurda77.transpher_frontend.databinding.ActivityWorkBinding
import com.edurda77.transpher_frontend.model.LoginData

class WorkActivityUser : AppCompatActivity() {
    private lateinit var binding: ActivityWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arguments = intent.extras

        if (arguments != null) {
            val room = arguments.getSerializable(LoginData::class.java.simpleName) as LoginData
            binding.nameUserText.text = room.loginUser
            binding.lastDataText.text = room.currentData.toString()
            binding.editNewData.hint = room.currentData.toString()
        }
    }
}