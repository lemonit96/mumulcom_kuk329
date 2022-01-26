package com.example.mumulcom

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mumulcom.databinding.ActivityQuestionBoardBinding


// Frame62
class QuestionBoardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityQuestionBoardBinding
    private var codingQuestionCheck : Boolean = true // default 값
    private var conceptQuestionCheck : Boolean = false // default 값
    private var recentQuestionCheck : Boolean = true
    private var hotQuestionCheck : Boolean = false
    private var ifOnlySeeCommentQuestion : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val title = intent.getStringExtra("category")
        binding.categoryNameTv.text = title

        initView()  // view 초기화
        initCodingOrConceptQuestionButton() // 코딩 질문 & 개념 질문 버튼 초기화
        initRecentOrHotQuestionTextButton() // 최신순 & 핫한순 버튼 초기화
        initCheckCommentButton() // 답변 달린 글만 보기 버튼 초기화


        // 새로고침
        binding.refreshLayout.setOnRefreshListener {
            // todo 서버에서 데이터 reload


            binding.refreshLayout.isRefreshing = false
        }






    }// end of onCreate




    // 함수

    private fun initView(){
        // 상단 뒤로가기 버튼
        binding.backIv.setOnClickListener {
            finish()
        }

        // 코딩 질문 버튼
        binding.codingQuestionIv.setOnClickListener {
            codingQuestionCheck = true
            conceptQuestionCheck = false
            initCodingOrConceptQuestionButton()
        }


        // 개념 질문 버튼
        binding.conceptQuestionIv.setOnClickListener {
            conceptQuestionCheck= true
            codingQuestionCheck = false
            initCodingOrConceptQuestionButton()
        }

        // 최신순
        binding.sortRecentTv.setOnClickListener {
            recentQuestionCheck = true
            hotQuestionCheck = false
            initRecentOrHotQuestionTextButton()

        }

        //핫한순
        binding.sortHotTv.setOnClickListener {
            hotQuestionCheck = true
            recentQuestionCheck = false
            initRecentOrHotQuestionTextButton()

        }


        // 답변 단글만 보기
        binding.ifAnswerIsCheckIv.setOnClickListener {
            ifOnlySeeCommentQuestion = !ifOnlySeeCommentQuestion
            initCheckCommentButton()

        }
    }

    private fun initRecentOrHotQuestionTextButton() {
        if(recentQuestionCheck){
            binding.sortRecentTv.setTextColor(Color.parseColor("#474A57"))
            binding.sortRecentTv.isEnabled = false
            // 최근 질문순으로 보여줌
        }else{
            binding.sortRecentTv.setTextColor(Color.parseColor("#C4C4C4"))
            binding.sortRecentTv.isEnabled = true
        }

        if(hotQuestionCheck){
            binding.sortHotTv.setTextColor(Color.parseColor("#474A57"))
            binding.sortHotTv.isEnabled = false
            // 인기 질문 순으로 보여줌
        }else{
            binding.sortHotTv.setTextColor(Color.parseColor("#C4C4C4"))
            binding.sortHotTv.isEnabled = true
        }

    }

    fun initCodingOrConceptQuestionButton(){

        if(codingQuestionCheck){
            binding.codingQuestionIv.setImageResource(R.drawable.coding_question_check_img)
            binding.codingQuestionIv.isEnabled = false // 이미 선택되었으면 선택 못함.
            // 코딩 질문만 보여줌
        }else{
            binding.codingQuestionIv.setImageResource(R.drawable.coding_question_img)
            binding.codingQuestionIv.isEnabled = true
        }

        if(conceptQuestionCheck){
            binding.conceptQuestionIv.setImageResource(R.drawable.concept_question_check_img)
            binding.conceptQuestionIv.isEnabled = false // 이미 선택되었으면 선택 못함.
            // 개념 질문만 보여줌

        }else{
            binding.conceptQuestionIv.setImageResource(R.drawable.concept_question_img)
            binding.conceptQuestionIv.isEnabled = true
        }

    }

    private fun initCheckCommentButton(){
        if(ifOnlySeeCommentQuestion){ // 답변 달린 댓글만 보기
            binding.ifAnswerIsCheckIv.setImageResource(R.drawable.ic_check_ok)
            // todo 답변 달린 댓글만 가져오기


        }else{
            binding.ifAnswerIsCheckIv.setImageResource(R.drawable.ic_check_no)
            // todo 답변 달린 댓글만 가져오기
        }
    }


}// end of class