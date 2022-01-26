package com.example.mumulcom

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import com.example.mumulcom.databinding.ActivityLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause.*
import com.kakao.sdk.user.UserApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var loginView: LoginView

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 해쉬 값 구하기
        /*
        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)
        */

        // 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                // 새롭게 로그인 필요
                // Toast.makeText(this, "새로운 로그인 필요", Toast.LENGTH_SHORT).show()
            }
            else if (tokenInfo != null) {
                // 서버에 사용자가 이미 존재하면 = 카카오 로그인이 이미 되어있으면
                Toast.makeText(this, "기존 로그인 유지 성공", Toast.LENGTH_SHORT).show()

                // 서버에 저장되어 있는 사용자 정보 받아오기
                login(user)
                //getJwt()


                // 메인 액티비티로 사용자 정보 전달하기
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == Unauthorized.toString() -> {
                        Toast.makeText(this, "앱에 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                // 처음 로그인에 성공하면
                Toast.makeText(this, "카카오톡 계정 연결 성공", Toast.LENGTH_SHORT).show()

                // 사용자 이메일, 닉네임 저장한 후
                // 추가 정보 입력 (사인 업 액티비티) 으로 넘어가기
                //val intent = Intent(this, SignUpActivity::class.java)
                //startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

                startActivity(Intent(this, SignUpActivity::class.java))
                finish()
            }
        }

        // 사용자 정보 요청
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n이름: ${user.kakaoAccount?.name}" +
                        "\n생년월일: ${user.kakaoAccount?.birthday}")
            }
        }


        val kakao_login_button = findViewById<ImageButton>(R.id.login_kakao_ib) // 로그인 버튼
        kakao_login_button.setOnClickListener {
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this)){
                UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
            }else{
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }

    fun login(user: User) {
        val authService = getRetrofit().create(AuthRetrofitInterface::class.java)

        loginView.onLoginLoading()

        authService.login(user).enqueue(object : Callback<AuthResponse> {
            @SuppressLint("LongLogTag")
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                Log.d("LOGINACT/API-RESPONSE", response.toString())

                if(response.isSuccessful && response.code() == 200) {
                    val resp = response.body()!!
                    Log.d("LOGINACT/API-RESPONSE-FLO", resp.toString())

                    when(resp.code) {
                        1000 -> loginView.onLoginSuccess(resp.result!!)
                        else -> loginView.onLoginFailure(resp.code, resp.message)
                    }
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("LOGINACT/API-ERROR", t.toString())

                loginView.onLoginFailure(400, "네트워크 오류가 발생했습니다.")
            }
        })
    }
}