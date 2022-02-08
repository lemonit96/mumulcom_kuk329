package com.example.mumulcom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumulcom.databinding.QuestionListItemBinding
import com.example.mumulcom.dataclass.Question


// XXXXXXX xxxxxxxxxxxxxxxxxxxxxxxxxxx 삭제할 파일 xxxxxxxxxxxxxxxxxxxxxxxxxxxxx


class MyQuestionAdapter(private val questionList:ArrayList<Question>):RecyclerView.Adapter<MyQuestionAdapter.ViewHolder>() {

    // 클릭 인터페이스 정의
    interface MyQuestionClickListener{
        fun onItemClick(question: Question)
    }

    // 리스너 객체를 전달받는 함수랑 리스너 객체를 저장할 변수
    private lateinit var myQuestionClickListener: MyQuestionClickListener

    fun setMyQuestionClickListener(questionClickListener: MyQuestionClickListener){
        myQuestionClickListener = questionClickListener

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:QuestionListItemBinding = QuestionListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questionList[position])
        // recyclerView 각 아이템을 클릭할때
        holder.itemView.setOnClickListener {
            myQuestionClickListener.onItemClick(questionList[position])

        }
    }

    override fun getItemCount(): Int =questionList.size


    inner class ViewHolder(val binding:QuestionListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(question: Question){
            binding.itemNameTv.text = question.nickname
            binding.itemDateTv.text = question.createdAt
            binding.itemTitleTv.text = question.title

        }
    }

}