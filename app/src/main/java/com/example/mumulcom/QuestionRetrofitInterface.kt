package com.example.mumulcom

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// 질문정보를 서버에서 받아올때 이용
interface QuestionRetrofitInterface {
    @GET("/questions/latest/{userIdx}")
    fun getQuestions(
        @Path("userIdx") userIdx : Long
    ): Call<QuestionResponse>
}