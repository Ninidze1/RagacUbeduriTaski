package com.example.shemajamebeli5.fragments

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shemajamebeli5.InputModel
import com.example.shemajamebeli5.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val inputLiveData = MutableLiveData<List<List<InputModel>>>().apply {
        mutableListOf<List<InputModel>>()
    }

    val _inputLiveData: MutableLiveData<List<List<InputModel>>> = inputLiveData

    private val fieldData = MutableLiveData<MutableMap<Int, String>>().apply {
        mutableListOf<MutableMap<Int, String>>()
    }

    val _fieldData: MutableLiveData<MutableMap<Int, String>> = fieldData


    fun init() {
        CoroutineScope(Dispatchers.Default).launch {
            getInput()
        }
    }

    private suspend fun getInput() {
        val result = RetrofitService.retrofitService().getInputInfo()
        if (result.isSuccessful) {
            val item = result.body()
            inputLiveData.postValue(item)

        }
    }

}