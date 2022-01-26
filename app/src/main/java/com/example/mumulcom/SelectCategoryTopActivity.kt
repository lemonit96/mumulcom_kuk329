package com.example.mumulcom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mumulcom.databinding.ActivityAftercheckbuttonBinding
import com.example.mumulcom.databinding.ActivitySelectcategorytopBinding

class SelectCategoryTopActivity: AppCompatActivity() {

    lateinit var binding: ActivitySelectcategorytopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectcategorytopBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}