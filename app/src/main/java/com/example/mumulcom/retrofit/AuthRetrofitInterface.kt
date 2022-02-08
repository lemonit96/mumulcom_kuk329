package com.example.mumulcom.retrofit

import com.example.mumulcom.AuthResponse
import com.example.mumulcom.dataclass.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users")
    fun signUp(@Body user: User): Call<AuthResponse>

    @POST("/users/login")
    fun login(@Body user: User): Call<AuthResponse>
}