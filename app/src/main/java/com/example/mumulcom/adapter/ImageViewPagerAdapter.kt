package com.example.mumulcom.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

// 질문 상세 보기 페이지에서 이미지들 보여줄때 사용하는 adapter
class ImageViewPagerAdapter(private val context: Context,private val list:ArrayList<String>): PagerAdapter() {


    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view===`object`
    }

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//
//    }
}