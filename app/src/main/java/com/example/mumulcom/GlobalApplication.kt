package com.example.mumulcom

import android.app.Application
import com.kakao.sdk.common.KakaoSdk


class GlobalApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // 카카오 SDK 초기화 (네이티브 앱 키)
        KakaoSdk.init(this, "0b9d6f7c3471d52a8c2d761dda556e34")
    }
}