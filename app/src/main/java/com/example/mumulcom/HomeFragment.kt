package com.example.mumulcom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mumulcom.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var recentQuestions = ArrayList<Question>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        for(i in 0..3){
            recentQuestions.add(Question("$i person","2022-01-($i)","I have a question"))
        }


//        val recentQuestionAdapter = RecentQuestionAdapter(recentQuestions)
//        binding.recentQuestionVp.adapter = recentQuestionAdapter
//        binding.recentQuestionVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        binding.homeIndicator.setViewPager(binding.recentQuestionVp)











        // 나의 최근 질문 전체보기
        binding.watchRecentQuestionAllTv.setOnClickListener {
            startActivity(Intent(context,MyQuestionAllActivity::class.java))
        }

        initCategoryButton()

        return binding.root
    }

    private fun initCategoryButton() {
        // ------------          앱       -------------------------
        binding.appAllTv.setOnClickListener {
            //앱  전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","앱")
            startActivity(intent)
        }
        binding.androidTv.setOnClickListener {
            // 안드로이드 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","안드로이드")
            startActivity(intent)
        }
        binding.iosTV.setOnClickListener {
            // IOS 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","ios")
            startActivity(intent)
        }



        // --------------         웹       -----------------------------

        binding.webAllTv.setOnClickListener {
            //웹  전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","웹")
            startActivity(intent)
        }
        binding.htmlTv.setOnClickListener {
            //html  전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","HTML")
            startActivity(intent)
        }
        binding.cssTv.setOnClickListener {
            //CSS  전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","CSS")
            startActivity(intent)
        }
        binding.reactTv.setOnClickListener {
            // React 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","React")
            startActivity(intent)
        }


        // --------------         서버      -----------------------------

        binding.serverAllTv.setOnClickListener {
            //서버  전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","서버")
            startActivity(intent)
        }


        binding.nodeTv.setOnClickListener {
            // Node Js 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","Node Js")
            startActivity(intent)
        }

        binding.springTv.setOnClickListener {
            //  SPRING   게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","Spring")
            startActivity(intent)
        }
        // --------------         프로그래밍 언어      -----------------------------

        binding.languageAllTv.setOnClickListener {
            //프로그래밍 언어 전체 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","프로그래밍 언어")
            startActivity(intent)
        }
        binding.cTv.setOnClickListener {
            // C 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","프로그래밍 언어")
            startActivity(intent)
        }
        binding.javaTv.setOnClickListener {
            // Java 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","Java")
            startActivity(intent)
        }
        binding.jSTv.setOnClickListener {
            // Js 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","JavaScript")
            startActivity(intent)
        }
        binding.pythonTv.setOnClickListener {
            // Python 게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","Python")
            startActivity(intent)
        }

        binding.cPlusTv.setOnClickListener {
            // C++  게시판 클릭시
            val intent = Intent(context,QuestionBoardActivity::class.java,)
            intent.putExtra("category","C++")
            startActivity(intent)
        }
        binding.etcAllTv.setOnClickListener {
            // 기타 게시판
            val intent = Intent(context,QuestionBoardActivity::class.java)
            intent.putExtra("category","기타")
            startActivity(intent)
        }




    }


}