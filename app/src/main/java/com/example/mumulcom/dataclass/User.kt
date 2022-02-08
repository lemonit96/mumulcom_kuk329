package com.example.mumulcom.dataclass

data class User(
    val email: String,  // 변경 불가능 (id값이나 마찬가지)
    val name: String,   // 변경 불가능
    var birth: String = " ",    // 빈 문자열 처리
    var nickname: String,   // 변경 가능
    var group: String,   // 변경 가능
    var field: ArrayList<String>   // 변경 가능, 스킵 가능
)
