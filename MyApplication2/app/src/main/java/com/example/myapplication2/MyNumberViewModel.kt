package com.example.myapplication2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class MyNumberViewModel:ViewModel() {
    private val TAG = "MyNumberViewModel"


    private val _currentValue = MutableLiveData<Int>()
    val currentValue:LiveData<Int>
        get() = _currentValue

    init {
        Log.d(TAG, ": 생성자 호출")

        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType,input:Int){
        when(actionType){
            ActionType.PLUS -> _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS -> _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}