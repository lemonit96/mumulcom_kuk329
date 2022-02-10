package com.example.mumulcom

import com.example.mumulcom.Auth

interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code:Int, message:String)
}