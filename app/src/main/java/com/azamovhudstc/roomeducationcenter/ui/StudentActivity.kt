package com.azamovhudstc.roomeducationcenter.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.azamovhudstc.roomeducationcenter.R
import com.azamovhudstc.roomeducationcenter.adapterimport.StudentAdapter
import com.azamovhudstc.roomeducationcenter.db.AppDataBase
import com.azamovhudstc.roomeducationcenter.entity.StudentEntity
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.dialog_view.view.*

class StudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        val database =AppDataBase.getInstance().getStudentDao()
        var get=intent.getIntExtra("groupId",0)
        titleStudents.text = "Students :${database.getAllStudentById(get).size}"
        var rvAdapter= StudentAdapter(database.getAllStudentById(get) as ArrayList<StudentEntity>,object :StudentAdapter.OnStudentClick{
            override fun onClick(course: StudentEntity) {
            }
        })
        student_rv.adapter=rvAdapter
        addStudent.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Student Qo`shish")
            var view = LayoutInflater.from(this).inflate(R.layout.dialog_view, null, false)
            view.titleDialog.hint="Student name"
            alert.setView(view)

            alert.setPositiveButton("Qo`shish"
            ) { dialog, which ->
                if (view.titleDialog.text.toString().trim().isNotEmpty()) {
                    var course =
                        StudentEntity(name = view.titleDialog.text.toString(), byGroupId = get)
                    database.addStudent(course)
                    rvAdapter.clearItem(database.getAllStudentById(get) as ArrayList<StudentEntity>)
                    Toast.makeText(this@StudentActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                    titleStudents.text = "Students :${database.getAllStudentById(get).size}"

                } else {
                    Toast.makeText(
                        this@StudentActivity,
                        "Maydonlarni to`ldiring",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            rvAdapter.clearItem(database.getAllStudentById(get) as ArrayList<StudentEntity>)
            alert.setNegativeButton("Bekor qilish",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    dialog?.dismiss()
                    Toast.makeText(this@StudentActivity, "Bekor qilindi", Toast.LENGTH_SHORT).show()
                }
            })
            alert.show()
        }


    }
}