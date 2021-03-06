package com.example.mumulcom

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.example.mumulcom.databinding.ActivityCamerapermissionBinding
import com.example.mumulcom.databinding.ActivityCamerapermissionaccessBinding
import java.util.*
import java.util.jar.Manifest


class CameraPermissionAccessActivity:AppCompatActivity() {

    lateinit var binding: ActivityCamerapermissionaccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCamerapermissionaccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.camerapermissionaccessCameraIV.setOnClickListener {
            startActivity(Intent(this, CameraShootingActivity::class.java))
        }

        binding.camerapermissionaccessGalleryIv.setOnClickListener {
            startActivity(Intent(this, CameraShootingActivity::class.java))
        }

    }

}