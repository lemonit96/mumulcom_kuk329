package com.example.mumulcom

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("questionIdx") val questionIdx: Long, // 질문 고유 번호
    @SerializedName("nickname") val name: String, // 작성자 이름
    @SerializedName("createdAt") val created: String, // 작성한 날짜
    @SerializedName("title") val title: String, // 질문 제목
    @SerializedName("likeCount") val Like: Int, // 좋아요 한 갯수
    @SerializedName("replyCount") val reply: Int, // 답변 갯수
    @SerializedName("bigCategory") val bigCategory: String,
    @SerializedName("smallCategory") val smallCategory: String,
){

}

