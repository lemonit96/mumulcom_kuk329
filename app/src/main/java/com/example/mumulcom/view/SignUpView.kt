package com.example.mumulcom.view

interface SignUpView {
    fun onLoginLoading()
    fun onSignUpSuccess()
    fun onSignUpFailure(code: Int, message: String)
}