package com.example.kotlintutorials.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.item_view_pager.view.*

//val images: List<Int>  since we have addded the images, ,amanually, they have ids of integers
class AdapterViewPager(val images: List<Int> ): RecyclerView.Adapter<AdapterViewPager.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = images[position]
        holder.itemView.iv_image.setImageResource(currentImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}