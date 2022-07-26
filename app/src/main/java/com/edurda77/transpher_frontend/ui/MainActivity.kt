package com.edurda77.transpher_frontend.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.edurda77.transpher_frontend.databinding.ActivityMainBinding
import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.utils.StateMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel  by viewModel()
private lateinit var tmp:LoginData
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            /*val intent = Intent(this@MainActivity, WorkActivityUser::class.java)
            intent.putExtra("DRD", "tmp")
            startActivity(intent)*/


        viewModel.commonData.observe(this) {
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
                is StateMainActivity.SuccessSingle -> {

                    binding.progressBar.isVisible = false
                    binding.textInput.isVisible = false
                    //binding.textInput.text = it.data.toString()
                    binding.login.isVisible = false
                    binding.password.isVisible = false
                    binding.ok.isVisible = false
                    tmp = it.data
                        val intent = Intent(this@MainActivity, WorkActivityUser::class.java)
                        intent.putExtra(LoginData::class.java.simpleName, tmp)
                        startActivity(intent)


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