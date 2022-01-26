package com.example.mumulcom

import android.content.Intent
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
        val myQuestionAdapter = MyQuestionAdapter(myQuestions)

        myQuestionAdapter.setMyQuestionClickListener(object:MyQuestionAdapter.MyQuestionClickListener{
            override fun onItemClick(question: Question) {
                startQuestionActivity(question) // 질문에 대한 정보 전달
            }
        })

        binding.questionAllRv.adapter = myQuestionAdapter

        binding.backIv.setOnClickListener {
            finish()
        }
    }// end of onCreate


    private fun startQuestionActivity(question:Question){
        val intent = Intent(this,QuestionActivity::class.java)
        intent.putExtra("Question-title",question.questionTitle)
        intent.putExtra("Question-name",question.userName)
        startActivity(intent)
    }
}// end of class