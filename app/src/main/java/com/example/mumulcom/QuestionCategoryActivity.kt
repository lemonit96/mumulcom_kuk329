package com.example.mumulcom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.mumulcom.databinding.ActivityQuestioncategoryBinding
import android.widget.RadioButton




class QuestionCategoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestioncategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestioncategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        completion()

        binding.questioncategorySelectCompletionIb.setOnClickListener {
            setSelectStatus(false)
        }

        binding.questioncategoryClickSelectCompletionIb.setOnClickListener {
            setSelectStatus(true)
            startActivity(Intent(this, AfterCheckbuttonActivity::class.java))
        }
    }

//    fun completion(){
//        if(binding.questioncategoryCodingQuestionIb.isChecked()==false&&binding.questioncategoryConceptQuestionIb.isChecked()==false){
//            binding.questioncategorySelectCompletionIb.setOnClickListener{
//                Toast.makeText(this, "질문 유형을 선택해주세요", Toast.LENGTH_SHORT).show()
//            }
//        }
//        if(binding.questioncategoryCodingQuestionIb.isChecked()==true||binding.questioncategoryConceptQuestionIb.isChecked()==true){
//            binding.questioncategorySelectCompletionIb.setOnClickListener {
//                setSelectStatus(false)
//                startActivity(Intent(this, CameraPermissionActivity::class.java))
//            }
//        }
//        else{
//            binding.questioncategorySelectCompletionIb.setOnClickListener {
//                setSelectStatus(false)
//                startActivity(Intent(this, CameraPermissionActivity::class.java))
//            }
//        }

    fun setSelectStatus(isSelect: Boolean) {
        if (isSelect) {
            binding.questioncategorySelectCompletionIb.visibility = View.VISIBLE
            binding.questioncategoryClickSelectCompletionIb.visibility = View.GONE
        } else {
            binding.questioncategorySelectCompletionIb.visibility = View.GONE
            binding.questioncategoryClickSelectCompletionIb.visibility = View.VISIBLE
        }
    }
}