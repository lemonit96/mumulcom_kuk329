package com.example.mumulcom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumulcom.databinding.ActivityMyQuestionAllBinding
import com.example.mumulcom.databinding.QuestionListItemBinding
import com.example.mumulcom.databinding.RecentQuestionLsitItemBinding

class RecentQuestionAdapter(private val questionList:ArrayList<Question>):RecyclerView.Adapter<RecentQuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(val binding: RecentQuestionLsitItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(question:Question){
            binding.itemNameTv.text = question.userName
            binding.itemDateTv.text = question.date
            binding.itemTitleTv.text = question.questionTitle
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentQuestionAdapter.QuestionViewHolder {
        val binding:RecentQuestionLsitItemBinding = RecentQuestionLsitItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentQuestionAdapter.QuestionViewHolder, position: Int) {
        holder.bind(questionList[position])
    }

    override fun getItemCount(): Int {
        return questionList.size
    }
}