package com.example.mumulcom.view

import com.example.mumulcom.dataclass.DetailCodingQuestion
import com.example.mumulcom.dataclass.Question

interface DetailCodingQuestionView {
    fun onGetDetailCodingQuestionsLoading()
    fun onGetDetailCodingQuestionsSuccess(result: ArrayList<DetailCodingQuestion>)
    fun onGetDetailCodingQuestionsFailure(code:Int, message:String)
}