package com.edurda77.transpher_frontend.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edurda77.transpher_frontend.databinding.ActivityWorkBinding
import com.edurda77.transpher_frontend.model.LoginData
import com.edurda77.transpher_frontend.model.UpdateDataModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkActivityUser : AppCompatActivity() {
    private val viewModel: WorkActivityViewModel by viewModel()
    private lateinit var binding: ActivityWorkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arguments = intent.extras

        if (arguments != null) {
            val room = arguments.getSerializable(LoginData::class.java.simpleName) as LoginData
            binding.nameUserText.text = room.loginUser
            binding.lastDataShow.text = room.currentData.toString()
            binding.editNewData.hint = room.currentData.toString()
            binding.sendNewData.setOnClickListener {
                val newData = binding.editNewData.text.toString()
                if (newData.toInt() >= room.currentData) {
                    viewModel.UpdateData(
                        UpdateDataModel(
                            transferLogin = room.loginUser,
                            transferPassword = room.loginPassword,
                            transferData = newData.toInt()
                        )
                    )
                    viewModel.commonData.observe(this) {
                        binding.lastDataShow.text
                            binding.editNewData.hint
                    }
                } else {
                    Toast.makeText(this, "Новые показания меньше предыдущих", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}