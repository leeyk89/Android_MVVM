package com.example.login.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.login.Model.M_Login
import java.io.Console
import android.text.TextUtils
import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import com.example.login.Common.Define
import com.example.login.Interface.I_Login


class VM_Login:ViewModel(),I_Login {

    private lateinit var m_Login:M_Login

    //1 로그인 승인, 2: Email형식 이상, 3: Network 이상 PW는 잘못 입렸했는지
    val isInvalidLogin = MutableLiveData<Define.LOGIN>()

    init {
        m_Login = M_Login()

    }


    fun requestLogin(id: String?, pw: String?){

        if (id != null && pw != null) {
            Log.i("ex",id)
            if(isValidEmail(id)){

                    m_Login.requestLoginAPI(id,pw,this)

            }else{
                isInvalidLogin.value = Define.LOGIN.EMAIL_ERROR

            }

        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    //숫자, 문자, 특수문자 중 2가지 포함(6~15자) -> 로그인에 쓰는거 아님 회원가입할 때 쓰라고 남겨놓거임.
    fun isValidPassword(password: String): Boolean {
        return password.matches("^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#\$%^&*])(?=.*[0-9!@#\$%^&*]).{6,15}\$".toRegex())
    }

    override fun resultLogin(result: Boolean) {
        //로그인 Web API로 요청 결과가 온다.
        //True : 로그인 성공
        if(result){
            isInvalidLogin.value = Define.LOGIN.OK
        }else{
            isInvalidLogin.value = Define.LOGIN.NETWORK_ERROR
        }
    }

}