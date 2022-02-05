package com.example.mumulcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mumulcom.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    // xxxxxxxxxxxxxxxxxxxx 삭제할 파일 xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

    private lateinit var binding : ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val intent = intent
        val title=intent.getStringExtra("Question-title")
        val name=intent.getStringExtra("Question-name")

        binding.questionTitleTv.setText(title)
        binding.questionPersonNameTv.setText(name)
    }
}