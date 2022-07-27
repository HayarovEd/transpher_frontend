package com.edurda77.transpher_frontend.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edurda77.transpher_frontend.databinding.ActivityMainBinding
import com.edurda77.transpher_frontend.databinding.ActivityWorkBinding

class WorkActivityUser : AppCompatActivity() {
    private lateinit var binding: ActivityWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}