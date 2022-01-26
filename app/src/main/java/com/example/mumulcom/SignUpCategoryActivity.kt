package com.example.mumulcom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mumulcom.databinding.ActivitySignupCategoryBinding

class SignUpCategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 카테고리 선택 시
        // 버튼 클릭할때마다 arrayList에 담아서
        // arrayList.length가 최대 5까지!

        // 건너뛰기 버튼 클릭 시 (field값은 null로 저장)
        // 선택완료 버튼 클릭 시
        // 사용자 정보 서버로 보내고 바로 MainActivity
    }

}