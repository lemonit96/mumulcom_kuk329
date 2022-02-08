package com.example.mumulcom

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mumulcom.databinding.ItemSliderBinding
import android.os.Environment

import android.R
import android.annotation.SuppressLint
import android.util.Log
import com.bumptech.glide.Glide
import com.example.mumulcom.dataclass.Question
import java.lang.Exception


class ViewPagerAdapter(val context: Context):RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    private val imgUrlList = ArrayList<String>()


    inner class PagerViewHolder(val binding: ItemSliderBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(url: String){
            Glide.with(context).load(url).into(binding.imageSlider)
        }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.PagerViewHolder {
        val binding: ItemSliderBinding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        Log.d("이미지test","어댑터로 이미지 들어옴 "+imgUrlList[position])
        holder.bind(imgUrlList[position])
    }

    override fun getItemCount(): Int {
        return imgUrlList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addQuestions(imgUrl:ArrayList<String>){
        this.imgUrlList.clear()
        this.imgUrlList.addAll(imgUrl)

        notifyDataSetChanged()
    }
}