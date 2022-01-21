package com.example.mumulcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mumulcom.databinding.ActivityQuestionBoardBinding


// Frame62
class QuestionBoardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}// end of class