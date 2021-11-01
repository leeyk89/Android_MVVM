package com.example.login.Model

import com.example.login.Interface.I_Login

class M_Login {



    fun requestLoginAPI(id: String, pw: String,i_Login:I_Login) {



        //로그인 결과가 True 라고 한다면
        i_Login.resultLogin(true);
        
        //Restful API 요청하는 방법 참조
        //https://jazzodevlab.tistory.com/68

    }


}