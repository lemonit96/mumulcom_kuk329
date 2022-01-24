package com.example.mumulcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mumulcom.databinding.ActivityMyQuestionAllBinding

class MyQuestionAllActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMyQuestionAllBinding
    private var myQuestions = ArrayList<Question>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyQuestionAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 0..10){
            myQuestions.add(Question("$i person","2022-01-($i)","I have a question"))
        }

        binding.questionAllRv.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        val recentQuestionAdapter = RecentQuestionAdapter(myQuestions)
        binding.questionAllRv.adapter = recentQuestionAdapter

        binding.backIv.setOnClickListener {
            finish()
        }
    }// end of onCreate
}// end of class