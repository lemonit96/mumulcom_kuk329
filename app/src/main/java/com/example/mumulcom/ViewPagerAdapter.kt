package com.example.mumulcom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter


//class ViewPagerAdapter(sliderlist: ArrayList<Int>):RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>(){
//
//    var image = sliderlist
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))
//
//    override fun getItemCount(): Int = image.size
//
//    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
//        holder.slider.setImageResource(image[position])
//    }
//
//    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
//        (LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)){
//
//        val slider = itemView.imageslider!!
//    }
//}
