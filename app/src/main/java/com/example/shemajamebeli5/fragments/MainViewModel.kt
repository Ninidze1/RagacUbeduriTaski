package com.example.shemajamebeli5.fragments

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val inputLiveData = MutableLiveData<List<InputModel>>().apply {
        mutableListOf<InputModel>()
    }

    val _inputLiveData: LiveData<List<InputModel>> = inputLiveData


    fun init() {
        CoroutineScope(Dispatchers.Default).launch {
            getInput()
        }
    }

    private suspend fun getInput() {
        val result = RetrofitService.retrofitService().getInputInfo()
        if (result.isSuccessful) {
            val item = result.body()
            d("tagtag", "$item")

        }
    }


}