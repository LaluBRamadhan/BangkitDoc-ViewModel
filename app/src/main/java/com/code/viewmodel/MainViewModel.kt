package com.code.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0

    fun Calculate(width: String, height: String, length: String){
        result = width.toInt() * height.toInt() * length.toInt()
    }
}