package com.example.mumulcom.view

import com.example.mumulcom.dataclass.DetailCodingQuestion
import com.example.mumulcom.dataclass.DetailConceptQuestion

interface DetailConceptQuestionView {
    fun onGetDetailConceptQuestionsLoading()
    fun onGetDetailConceptQuestionsSuccess(result: ArrayList<DetailConceptQuestion>)
    fun onGetDetailConceptQuestionsFailure(code: Int, message: String)
}