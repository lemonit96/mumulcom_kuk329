package com.example.mumulcom

import retrofit2.Call
import retrofit2.Response

class LikeQuestionService {
    private lateinit var likeQuestionView: LikeQuestionView

    fun setLikeQuestionService(likeQuestionView: LikeQuestionView){
        this.likeQuestionView = likeQuestionView
    }


    fun getLikeQuestion(X_ACCESS_TOKEN:String,questionIdx:Long,userIdx:Long){

        val likeQuestionService = getRetrofit().create(QuestionRetrofitInterface::class.java)

        likeQuestionView.onGetLikeQuestionLoading()


        likeQuestionService.getLikeQuestion(X_ACCESS_TOKEN,questionIdx,userIdx)
            .enqueue(object : retrofit2.Callback<LikeQuestionResponse>{
                override fun onResponse(call: Call<LikeQuestionResponse>, response: Response<LikeQuestionResponse>) {

                    val resp = response.body()!!

                    when(resp.code){

                        1000-> likeQuestionView.onGetLikeQuestionSuccess(resp.result)
                        else-> likeQuestionView.onGetLikeQuestionFailure(resp.code,resp.message)

                    }


                }

                override fun onFailure(call: Call<LikeQuestionResponse>, t: Throwable) {
                    likeQuestionView.onGetLikeQuestionFailure(400 ,"네트워크 오류가 발생했습니다.")
                }
            })

    }
}