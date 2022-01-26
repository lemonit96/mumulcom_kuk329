package com.example.mumulcom

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import com.example.mumulcom.databinding.ActivityAftercheckbuttonBinding
import androidx.viewpager2.widget.ViewPager2

import android.R
import android.view.View
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback


class AfterCheckbuttonActivity:AppCompatActivity() {

    lateinit var binding: ActivityAftercheckbuttonBinding

    private lateinit var getResultText: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAftercheckbuttonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.aftercheckbuttonBackIv.setOnClickListener {
            startActivity(Intent(this, CameraShootingActivity::class.java))
        }

        binding.aftercheckbuttonBackIv.setOnClickListener {
            startActivity(Intent(this, QuestionCategoryActivity::class.java))
        }

        binding.aftercheckbuttonEditIv.setOnClickListener {
            startActivity(Intent(this, CameraShootingActivity::class.java))
        }

//        binding.after

        //어댑터 연결하기
//        binding.aftercheckbuttonImageVp.adapter=ViewPagerAdapter(getsliderList())
//        binding.aftercheckbuttonImageVp.orientation=ViewPager2.ORIENTATION_HORIZONTAL

    }

//    fun getsliderList(): ArrayList<Int>{
//        return arrayListOf<Int>(R.drawable.)
//    }


}