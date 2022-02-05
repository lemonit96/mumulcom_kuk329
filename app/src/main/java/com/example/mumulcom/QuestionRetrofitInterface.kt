package com.example.mumulcom

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// 질문정보를 서버에서 받아올때 이용
interface QuestionRetrofitInterface {
    @GET("/questions/latest/{userIdx}") // 최근 질문 조회 (HomeFragment)
    fun getQuestions(
        @Path("userIdx") userIdx : Long
    ): Call<QuestionResponse>

    @GET("/questions?")  // 카테고리별 질문 조회 (QuestionBoardActivity)
    fun getCategoryQuestions(
        @Query("type") type:Int,   // 질문 유형 (코딩 질문: 1 / 개념 질문 : 2)
        @Query("sort") sort:Int, // 정렬 기준 (최신순 : 1/ 핫한순 : 2)
        @Query("bigCategoryIdx") bigCategoryIdx:Int?, // (ex.1)
        @Query("smallCategoryIdx") smallCategoryIdx:Int?, // (ex.1)
        @Query("isReplied") isReplied:Boolean, // (답변 달린 질문만 보기 (true) / 전체 질문 보기 (false)
        @Query("lastQuestionIdx") lastQuestionIdx:Int, // (ex. 1)  마지막으로 조회한 질문글 순서 번호
        @Query("perPage") perPage:Int, // 하나의 페이지당 조회할 질문 글 갯수
    ):Call<CategoryQuestionResponse>

}