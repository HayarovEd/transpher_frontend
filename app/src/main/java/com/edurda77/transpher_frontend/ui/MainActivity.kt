package com.edurda77.transpher_frontend.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.edurda77.transpher_frontend.databinding.ActivityMainBinding
import com.edurda77.transpher_frontend.utils.StateMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel  by viewModel()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.companiesData.observe(this) {
            when (it) {
                is StateMainActivity.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.textInput.isVisible = false
                    binding.login.isVisible = false
                    binding.password.isVisible = false
                    binding.ok.isVisible = false
                }
                is StateMainActivity.Failure -> {
                    binding.progressBar.isVisible = false
                    binding.textInput.isVisible = true
                    binding.textInput.text = it.msg.toString()
                    binding.login.isVisible = true
                    binding.password.isVisible = true
                    binding.ok.isVisible = true
                }
                is StateMainActivity.Success -> {
                    binding.progressBar.isVisible = false
                    binding.textInput.isVisible = true
                    binding.textInput.text = it.data.toString()
                    binding.login.isVisible = false
                    binding.password.isVisible = false
                    binding.ok.isVisible = false
                }
                is StateMainActivity.Success2 -> {
                    binding.progressBar.isVisible = false
                    binding.textInput.isVisible = true
                    binding.textInput.text = it.data.toString()
                    binding.login.isVisible = false
                    binding.password.isVisible = false
                    binding.ok.isVisible = false
                }
                else -> {
                    binding.progressBar.isVisible = false
                    binding.textInput.isVisible = true
                    binding.login.isVisible = true
                    binding.password.isVisible = true
                    binding.ok.isVisible = true
                }
            }
        }
        binding.ok.setOnClickListener {
            val inputLogin = binding.login.text.toString()
            val inputPassword = binding.password.text.toString()
            viewModel.getDataForShow(inputLogin, inputPassword)
        }
    }
}