package com.example.mumulcom

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailQuestionImgAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {

    val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment){
        // fragmentList 를 private 로 선언을 했기때문에 외부에서 임의로 접근이 불가능하다
        // 그래서 외부에서 이 변수에 접근을 하기위한 함수를 따로 만듬.
        fragmentList.add(fragment) // fragmentList 변수에 fragment 추가
        notifyItemInserted(fragmentList.size -1) // 추가된 아이템의 index 를 넘겨서 새 아이템이 추가되었다는 것을 알리는 함수.


    }

}