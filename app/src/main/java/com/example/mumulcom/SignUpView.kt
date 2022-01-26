package com.example.mumulcom

interface SignUpView {
    fun onLoginLoading()
    fun onSignUpSuccess()
    fun onSignUpFailure(code: Int, message: String)
}