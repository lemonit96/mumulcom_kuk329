package com.example.mumulcom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mumulcom.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    lateinit var group: String
    lateinit var nickname: TextView

    private var validNickname: Boolean = false   // 유효한 아이디인가
    private var validGroup: Boolean = false    // 소속을 선택했는가

    val nicknameValidation = "^[가-힣a-z0-9]{2,8}$"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinner()
        setupSpinnerHandler()

        // 닉네임 바로바로 검사
        nickname = findViewById(R.id.signup_nickname_et)

        nickname.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                // text가 변경된 후 호출
                // p0에는 변경 후의 문자열이 담겨있음
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // text가 변경되기 전 호출
                // p0에는 변경 전 문자열이 담겨있음
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // text가 바뀔때마다 호출
                checkNickname()
            }
        })


        // 닉네임 중복 검사 (중복확인버튼)
        binding.signupDuplicateCheckBt.setOnClickListener {
            var needCheckNickname = nickname.text.toString().trim()
            EnableNickname(needCheckNickname)
        }

        // 닉네임 소속 모두 제대로 입력됐는지 검사
        isValid(validNickname, validGroup)

        // 입력 완료 버튼 클릭하면 카테고리 선택 액티비티로 넘어가기
        binding.signupTypingDoneSelectIv.setOnClickListener {
            startActivity(Intent(this, SignUpCategoryActivity::class.java))
            finish()
        }
    }

    // dp 값을 px 값으로 변환해주는 함수
    private fun dipToPixels(dipValue: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dipValue,
            resources.displayMetrics
        )
    }

    // 스피너에 어레이 어댑터 연결
    private fun setupSpinner() {
        val groups = resources.getStringArray(R.array.signup_category)
        val adapter = object : ArrayAdapter<String>(this, R.layout.item_spinner){
            @SuppressLint("CutPasteId")
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val v = super.getView(position, convertView, parent)
                if(position == count) {
                    // 마지막 포지션의 textView를 힌트용으로 사용
                    (v.findViewById<View>(R.id.item_spinner_tv) as TextView).text = ""
                    // 아이템의 마지막 값을 불러와 hint로 추가함
                    (v.findViewById<View>(R.id.item_spinner_tv) as TextView).hint = getItem(count)
                }
                return v
            }
            override fun getCount(): Int {
                // 마지막 아이템은 hint용이기 때문에 1을 빼줌
                return super.getCount() - 1
            }
        }
        // 아이템 추가
        adapter.addAll(groups.toMutableList())
        // hint로 사용할 문구를 마지막 아이템에 추가
        adapter.add("클릭하여 소속 찾기")
        // 어댑터 연결
        binding.signupGroupSp.adapter = adapter
        // 스피너 초기값을 마지막 아이템으로 설정
        binding.signupGroupSp.setSelection(adapter.count)

        // droplist를 스피너와 간격을 두고 나오게 함 -> 아이템 크기 = 125px
        binding.signupGroupSp.dropDownVerticalOffset = dipToPixels(45f).toInt()
    }

    // 스피너 클릭 이벤트 핸들러
    private fun setupSpinnerHandler() {
        binding.signupGroupSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (!binding.signupGroupSp.getItemAtPosition(position).equals("클릭하여 소속 찾기")) {
                    // 소속을 선택하면 group 변수에 사용자 소속 저장하기
                    group = binding.signupGroupSp.getItemAtPosition(position).toString()
                    Log.d("사용자 소속", group)
                    validGroup = true
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    // 닉네임 유효성 검사 함수
    fun checkNickname(): Boolean {
        var n = nickname.text.toString().trim() // 공백제거
        val p = Pattern.matches(nicknameValidation, n) // 패턴 맞는지 확인
        return if (p) {
            // 닉네임 형태가 정상일 경우
            binding.signupNicknameValidIv.visibility = View.VISIBLE
            binding.signupNicknameErrorIv.visibility = View.GONE
            binding.signupNicknameErrorTv.visibility = View.GONE
            true
        } else {
            binding.signupNicknameRule1Tv.visibility = View.GONE
            binding.signupNicknameRule2Tv.visibility = View.GONE
            binding.signupNicknameValidIv.visibility = View.GONE
            binding.signupNicknameErrorIv.visibility = View.VISIBLE
            binding.signupNicknameErrorTv.visibility = View.VISIBLE
            false
        }
    }

    // 중복확인
    fun EnableNickname(needCheckNickname: String) {
        // 저장해서 서버에 보냄
        // 서버에서 중복확인 후 boolean 값 전송

        // 전송 받은 값 validNickname에 저장
        validNickname = true
    }

    // 유효한 아이디 & 소속 선택 하면 입력 완료 창 뜨기
    private fun isValid(validNickname: Boolean, validGroup: Boolean) {
        if (validNickname && validGroup) {
            binding.signupTypingDoneSelectIv.visibility = View.VISIBLE
            binding.signupTypingDoneNoSelectIv.visibility = View.GONE
        }
    }

    // 추가 정보 입력 칸이 종료
    override fun onDestroy() {
        super.onDestroy()
    }

}