package com.example.ex_mvvm

import androidx.lifecycle.MutableLiveData

class SignupModel {

    val results  = MutableLiveData<Boolean>()

    fun getResult():MutableLiveData<Boolean>{
        return results
    }

    fun requestLogin(id: String, pw: String) {
        //방법 1
        m_inter.resultLogin(true)

        //방법 2
        //results.value = true;
    }


    lateinit var m_inter:Interface_signup
    fun setLoginListener(interfaceSignup: Interface_signup){

        m_inter = interfaceSignup
    }

}