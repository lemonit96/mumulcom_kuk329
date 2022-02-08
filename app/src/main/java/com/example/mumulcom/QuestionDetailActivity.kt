package com.example.mumulcom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.mumulcom.adapter.DetailQuestionImgAdapter
import com.example.mumulcom.databinding.ActivityQuestionDetailBinding
import com.example.mumulcom.dataclass.DetailCodingQuestion
import com.example.mumulcom.dataclass.DetailConceptQuestion
import com.example.mumulcom.service.DetailCodingQuestionService
import com.example.mumulcom.service.DetailConceptQuestionService
import com.example.mumulcom.view.DetailCodingQuestionView
import com.example.mumulcom.view.DetailConceptQuestionView


// 질문 상세 페이지 (개념/코딩)
class QuestionDetailActivity : AppCompatActivity(), DetailCodingQuestionView ,DetailConceptQuestionView{
    private lateinit var binding : ActivityQuestionDetailBinding
    private lateinit var bigCategoryName : String
    private var questionIdx : Long = 0 // default 값
    private var type : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        bigCategoryName = intent.getStringExtra("bigCategoryName")!!
        questionIdx = intent.getLongExtra("questionIdx",0) // 받아온 질문 고유번호 -> api 호출시 넘김
        type = intent.getIntExtra("type",0) // 1: 코딩질문, 2: 개념질문
        binding.categoryNameTv.text = bigCategoryName
        Log.d("type확인 ",type.toString())

        when(type){
            1-> getDetailCodingQuestion() // 코딩 질문
            2-> getDetailConceptQuestion() // 개념질문
        }


        binding.backIv.setOnClickListener {  // 뒤로 가기 버튼 클릭시
            finish()
        }

    }// end of onCreate

    private fun getDetailConceptQuestion(){ // 개념질문 가져옴
        val detailConceptQuestionService = DetailConceptQuestionService()
        detailConceptQuestionService.setDetailConceptQuestionService(this)
        detailConceptQuestionService.getDetailConceptQuestion(questionIdx)

    }

    private fun getDetailCodingQuestion(){ // 코딩질문 가져옴
        val detailCodingQuestionService = DetailCodingQuestionService()
        detailCodingQuestionService.setDetailCodingQuestionService(this)
        detailCodingQuestionService.getDetailConceptQuestion(questionIdx)

    }

    // ----------- DetailConceptQuestionView implement : 개념 질문 -----------------

    override fun onGetDetailConceptQuestionsLoading() {
        Log.d("개념질문 상세페이지/API","로딩중...")
    }

    override fun onGetDetailConceptQuestionsSuccess(result: ArrayList<DetailConceptQuestion>) {
//        Log.d("size 확인111",result.size.toString())
//        Log.d("size 확인111",result[0].nickname)
        binding.nickNameTv.text = result[0].nickname // 닉네임
        binding.createdAtTv.text = result[0].createdAt // 작성날짜
        binding.questionIv.setImageResource(R.drawable.ic_concept_question_check_img) // 코딩 이미지로바꿈
        Glide.with(this).load(result[0].profileImgUrl).into(binding.profileIv) // 프로필 이미지
        binding.titleTv.text = result[0].title // 제목
        binding.bigCategoryTv.text = "#"+result[0].bigCategoryName // 상위 카테고리
        if(result[0].smallCategoryName!=null){
            binding.smallCategoryTv.text = "#"+result[0].smallCategoryName // 하위 카테고리
        }
        // todo 이미지 있으면 그 수만큼 viewpager 어댑터에 넘기고 없으면 이미지 보여주는 부분 gone 처리
        if(result[0].questionImgUrls.size==0) {
            binding.pictureLinearLayout.visibility = View.GONE
            Log.d("이미지test", "사진 viewpager gone")
        }

        binding.currentErrorTv.text = result[0].content // 질문 내용
        binding.codingSkillConstraintLayout.visibility = View.GONE

    }

    override fun onGetDetailConceptQuestionsFailure(code: Int, message: String) {
        when(code){
            400-> Log.d("개념질문 상세페이지/API",message)
        }
    }




    // ----------- DetailCodingQuestionView implement : 코딩 질문 -----------------

    override fun onGetDetailCodingQuestionsLoading() {
        Log.d("코딩질문 상세페이지/API","로딩중...")
    }

    override fun onGetDetailCodingQuestionsSuccess(result: ArrayList<DetailCodingQuestion>) {
//        Log.d("size 확인222",result.size.toString())
//        Log.d("size 확인222",result[0].nickname)
        binding.nickNameTv.text = result[0].nickname // 닉네임
        binding.createdAtTv.text = result[0].createdAt // 작성날짜
        Glide.with(this).load(result[0].profileImgUrl).into(binding.profileIv) // 프로필 이미지
        binding.titleTv.text = result[0].title // 제목
        binding.bigCategoryTv.text = "#"+result[0].bigCategoryName // 상위 카테고리
        if(result[0].smallCategoryName!=null){
            binding.smallCategoryTv.text = "#"+result[0].smallCategoryName // 하위 카테고리
        }

        // todo 이미지 있으면 그 수만큼 viewpager 어댑터에 넘기고 없으면 이미지 보여주는 부분 gone 처리
        Log.d("이미지test",result[0].questionImgUrls.toString())
//        Log.d("이미지test",result[0].questionImgUrls!!.isEmpty().toString())
//        Log.d("이미지test--",result[0].questionImgUrls[0].toString())

        if(result[0].questionImgUrls.size == 0){
            binding.pictureLinearLayout.visibility = View.GONE
            Log.d("이미지test","사진 viewpager gone")
        }else{
            val viewPagerAdapter = ViewPagerAdapter(this)
            viewPagerAdapter.addQuestions(result[0].questionImgUrls!!)
            binding.viewPager.adapter = viewPagerAdapter
            binding.indicator.setViewPager(binding.viewPager)


            Log.d("이미지test","어댑터로 넘김")

        }
        binding.currentErrorTv.text = result[0].currentError // 질문 내용


        if(result[0].myCodingSkill == null){ // 내 코딩 실력
            binding.codingSkillConstraintLayout.visibility = View.GONE
        }else{
            binding.myCodingSkillTv.text = result[0].myCodingSkill
        }

        Log.d("코딩질문 idx",result[0].questionIdx.toString())



    }

    override fun onGetDetailCodingQuestionsFailure(code: Int, message: String) {
        when(code){
            400-> Log.d("코딩질문 상세페이지/API",message)
        }
    }



}// end of class