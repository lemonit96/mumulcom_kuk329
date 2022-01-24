package com.example.mumulcom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumulcom.databinding.QuestionListItemBinding

class MyQuestionAdapter(private val questionList:ArrayList<Question>):RecyclerView.Adapter<MyQuestionAdapter.ViewHolder>() {



    inner class ViewHolder(val binding:QuestionListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(question:Question){
            binding.itemNameTv.text = question.userName
            binding.itemDateTv.text = question.date
            binding.itemTitleTv.text = question.questionTitle

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:QuestionListItemBinding = QuestionListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questionList[position])
    }

    override fun getItemCount(): Int =questionList.size

}