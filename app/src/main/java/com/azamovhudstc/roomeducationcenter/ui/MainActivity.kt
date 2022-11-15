package com.azamovhudstc.roomeducationcenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.azamovhudstc.roomeducationcenter.R
import com.azamovhudstc.roomeducationcenter.adapter.CourseAdapter
import com.azamovhudstc.roomeducationcenter.db.AppDataBase
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_view.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var courseDao =AppDataBase.getInstance().getCourseDao()
        var rvAdapter =CourseAdapter(courseDao.getAllCourse() as ArrayList<CourseEntity>,object : CourseAdapter.OnCourseClick {
            override fun onClick(course: CourseEntity) {
                var intent = Intent(this@MainActivity, GroupActivity::class.java)
                intent.putExtra("id", course.id)
                startActivity(intent)
            }
        })
        course_rv.adapter =rvAdapter
        addd.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Course Qo`shish")
            var view = LayoutInflater.from(this).inflate(R.layout.dialog_view, null, false)
            alert.setView(view)

            alert.setPositiveButton("Qo`shish"
            ) { dialog, which ->
                if (view.titleDialog.text.toString().trim().isNotEmpty()) {
                    var course = CourseEntity(name = view.titleDialog.text.toString())
                    courseDao.addCourse(course)
                    rvAdapter.clearItem(courseDao.getAllCourse() as ArrayList<CourseEntity>)
                    Toast.makeText(this@MainActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Maydonlarni to`ldiring",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            rvAdapter.clearItem(courseDao.getAllCourse() as ArrayList<CourseEntity>)

            alert.show()
        }
    }
}