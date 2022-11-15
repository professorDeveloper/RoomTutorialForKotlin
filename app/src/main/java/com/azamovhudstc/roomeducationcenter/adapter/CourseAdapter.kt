package com.azamovhudstc.roomeducationcenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.roomeducationcenter.R
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity
import kotlinx.android.synthetic.main.item.view.*

class CourseAdapter(var arrayList:ArrayList<CourseEntity>,var onCurClick: OnCourseClick): RecyclerView.Adapter<CourseAdapter.Wh>() {

    inner class Wh(view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun onBind(course: CourseEntity){
            itemView.title.text=course.name
            itemView.setOnClickListener {
                onCurClick.onClick(course)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(arrayList[position])
    }
    @SuppressLint("NotifyDataSetChanged")
    fun  clearItem(arrayLists: ArrayList<CourseEntity> ){
        arrayList.clear()
        arrayList.addAll(arrayLists)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    interface OnCourseClick{
        fun onClick(course: CourseEntity)
    }
}