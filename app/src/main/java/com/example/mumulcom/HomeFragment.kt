package com.example.mumulcom

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mumulcom.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var myQuestions = ArrayList<Question>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)



        binding.watchRecentQuestionAllTv.setOnClickListener {
            // Activity 변경
            startActivity(Intent(context,RecentQuestionAllActivity::class.java))
        }

        binding.appAllTv.setOnClickListener {
            //앱  전체 게시판 클릭시
            startActivity(Intent(context,QuestionBoardActivity::class.java))
        }

        return binding.root
    }


}