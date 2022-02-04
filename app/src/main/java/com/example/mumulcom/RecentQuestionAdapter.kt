package com.example.mumulcom

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumulcom.databinding.ActivityMyQuestionAllBinding
import com.example.mumulcom.databinding.QuestionListItemBinding
import com.example.mumulcom.databinding.RecentQuestionLsitItemBinding

class RecentQuestionAdapter(val context: Context):RecyclerView.Adapter<RecentQuestionAdapter.QuestionViewHolder>() {

    private val questions = ArrayList<Question>()

    // 외부 작업을 위한 클릭 인터페이스 정의
    interface MyItemClickListener {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentQuestionAdapter.QuestionViewHolder {
        val binding:RecentQuestionLsitItemBinding = RecentQuestionLsitItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecentQuestionAdapter.QuestionViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount(): Int {
        return questions.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addQuestions(questions:ArrayList<Question> ){
        this.questions.clear()
        this.questions.addAll(questions)

        notifyDataSetChanged()
    }


    inner class QuestionViewHolder(val binding: RecentQuestionLsitItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(question:Question){
            if(questions.size==0){
                //todo 내 질문이 없을때 처리 ( viewpager x)
            }
            binding.itemNameTv.text = question.name
            binding.itemDateTv.text = question.created
            binding.itemTitleTv.text = question.title
        }

    }
}