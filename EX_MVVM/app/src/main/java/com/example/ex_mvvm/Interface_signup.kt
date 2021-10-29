package com.example.ex_mvvm

interface Interface_signup {

    fun resultLogin(result:Boolean)
    fun networkCall ( onSuccess : (Boolean) -> Unit, onError : (Throwable) -> Unit ) {

        try {

            onSuccess (true)

        } catch ( e : Throwable ) {

            onError ( e )

        }

    }
}