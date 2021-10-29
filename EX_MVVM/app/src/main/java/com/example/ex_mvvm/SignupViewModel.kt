package com.example.ex_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject;

class SignupViewModel:ViewModel(),Interface_signup {

    val model = SignupModel()
    val isSuccessLogin = model.getResult()
    val isSuccessLogin2  = MutableLiveData<Boolean>()



    fun viewCommunication(id:String,pw:String){
        //방법 1,2의 차이는 
        //(방법1)Interface를 사용하여 CallBack 형식으로 구현하느냐
        //(방법2)로 Model에 있는 변수에 직접 Observ를 달아 변화를 감지하느냐 차이
        
        
        //방법 1
        model.setLoginListener(this)
        model.requestLogin(id,pw);

        //방법 1-1
//        model.setLoginListener(object :Interface_signup{
//            override fun resultLogin(result: Boolean) {
//                isSuccessLogin2.value = result
//            }
//        })

        //방법 2
        //model.requestLogin(id,pw);


    }

    override fun resultLogin(result: Boolean) {
        //Interface에 정의된 함수
        
        //view에서 Observ 하고 있는 isSuccessLogin2 값 변경
        isSuccessLogin2.value = result

    }

}