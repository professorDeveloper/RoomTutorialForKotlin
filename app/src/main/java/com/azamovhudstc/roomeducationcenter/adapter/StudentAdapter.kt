package com.azamovhudstc.roomeducationcenter.adapterimport

import android.annotation.SuppressLint

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.roomeducationcenter.R
import com.azamovhudstc.roomeducationcenter.entity.StudentEntity
import kotlinx.android.synthetic.main.item.view.*

class StudentAdapter(var arrayList:ArrayList<StudentEntity>, var onCurClick: OnStudentClick):RecyclerView.Adapter<StudentAdapter.Wh>() {

    inner class Wh(view:View):RecyclerView.ViewHolder(view) {
        fun onBind(course: StudentEntity){
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
    fun  clearItem(arrayLists: ArrayList<StudentEntity> ){
        arrayList.clear()
        arrayList.addAll(arrayLists)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    interface OnStudentClick{
        fun onClick(course: StudentEntity)
    }
}