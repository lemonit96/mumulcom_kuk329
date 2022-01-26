package com.example.mumulcom

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.mumulcom.databinding.ActivityCamerapermissionBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class CameraPermissionActivity:AppCompatActivity() {

    lateinit var binding: ActivityCamerapermissionBinding
//    lateinit var currentPhotoPath: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCamerapermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.camerapermissionNextIb.setOnClickListener {
//            finish()
//        }

//        binding.camerapermissionaccssIb.setOnClickListener {
//            startActivity(Intent(this, CameraPermissionAccessActivity::class.java))
//        }


        binding.camerapermissionNextIb.setOnClickListener {
            startActivity(Intent(this, AfterCheckbuttonActivity::class.java))
        }

        binding.camerapermissionaccssIb.setOnClickListener {
                startActivity(Intent(this, CameraShootingActivity::class.java))
        }
    }

//    fun openSomeActivityForResult() {
//        val intent = Intent(this, CameraPermissionActivity::class.java)
//        val resultLauncher =
//            registerForActivityResult(
//                ActivityResultContracts.StartActivityForResult()
//            ) {
//                if (it.resultCode == Activity.RESULT_OK) {
//                    val value = it.data?.getStringExtra("input")
//                }
//            }
//        resultLauncher.launch(intent)
//    }

}