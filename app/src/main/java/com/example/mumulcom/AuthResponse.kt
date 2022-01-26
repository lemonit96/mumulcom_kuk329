package com.example.mumulcom

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("jwt") val jwt: String?,
    @SerializedName("userIdx") val userIdx: Long,
    @SerializedName("email") val email: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("nickname") val nickname: String?
)

data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code:Int,
    @SerializedName("message") val message:String,
    @SerializedName("result") val result: Auth?
)
