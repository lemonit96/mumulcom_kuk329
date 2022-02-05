package com.example.mumulcom

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mumulcom.databinding.RecentQuestionListItemBinding

class RecentQuestionAdapter(val context: Context):RecyclerView.Adapter<RecentQuestionAdapter.QuestionViewHolder>() {

    private val questions = ArrayList<Question>()

    // 외부 작업을 위한 클릭 인터페이스 정의
    interface MyItemClickListener {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentQuestionAdapter.QuestionViewHolder {
        val binding:RecentQuestionListItemBinding = RecentQuestionListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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


    inner class QuestionViewHolder(val binding: RecentQuestionListItemBinding):RecyclerView.ViewHolder(binding.root){


        fun bind(question:Question){
            if(questions.size==0){
                //todo 내 질문이 없을때 처리 ( viewpager x)
            }
            Glide.with(context).load(question.profileImgUrl).into(binding.itemIconIv) // 프로필 이미지
            binding.itemNameTv.text = question.nickname // 닉네임
            binding.itemDateTv.text = question.createdAt // 질문한 날짜
            binding.itemTitleTv.text = question.title // 질문 제목

            binding.itemCommentTv.text = question.replyCount.toString() // 답변 갯수
            binding.itemLikeTv.text  = question.likeCount.toString() // 좋아요 갯수


            binding.itemBigCategoryTv.text = "#"+question.bigCategoryName

            if(question.smallCategoryName!=null){
                binding.itemSmallCategoryTv.text = "#"+question.smallCategoryName
            }




        }

    }
}