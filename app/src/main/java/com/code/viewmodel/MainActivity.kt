package com.code.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.code.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener{
            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()

            when{
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Masih Kosong"
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Masih Kosong"
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Masih Kosong"
                }
                else -> {
                    viewModel.Calculate(width,height,length)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}