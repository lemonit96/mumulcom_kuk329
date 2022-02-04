package com.example.mumulcom

import com.google.gson.annotations.SerializedName


//data class QuestionResult(
//    @SerializedName("questionIdx") val questionIdx: Long, // 질문 고유 번호
//    @SerializedName("name") val name: String, // 작성자 이름
//    @SerializedName("created") val created: String, // 작성한 날짜
//    @SerializedName("title") val String: Long, // 질문 제목
//    @SerializedName("Like") val Like: Long, // 좋아요 한 갯수
//    @SerializedName("reply") val reply: Long, // 답변 갯수
//    @SerializedName("bigCategory") val bigCategory: String,
//    @SerializedName("smallCategory") val smallCategory: String,
//)


data class QuestionResponse(

    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code:Int,
    @SerializedName("message") val message:String,
    @SerializedName("result") val result: ArrayList<Question>?

)
