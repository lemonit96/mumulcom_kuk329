package com.example.mumulcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mumulcom.databinding.ActivityRecentQuestionAllBinding

class RecentQuestionAllActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRecentQuestionAllBinding
    private var myQuestions = ArrayList<Question>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecentQuestionAllBinding.inflate(layoutInflater)
        setContentView(binding.root)


        for(i in 0..10){
            myQuestions.add(Question("$i person","2022-01-($i)","I have a question"))
        }

        binding.questionAllRv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val recentQuestionAdapter = RecentQuestionAdapter(myQuestions)
        binding.questionAllRv.adapter = recentQuestionAdapter


    }// end of onCreate
}// end of Class