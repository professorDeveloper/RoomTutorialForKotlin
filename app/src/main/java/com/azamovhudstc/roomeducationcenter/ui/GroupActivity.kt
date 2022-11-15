package com.azamovhudstc.roomeducationcenter.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.azamovhudstc.roomeducationcenter.R
import com.azamovhudstc.roomeducationcenter.adapter.GroupAdapter
import com.azamovhudstc.roomeducationcenter.db.AppDataBase
import com.azamovhudstc.roomeducationcenter.entity.GroupEntity
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.dialog_view.view.*

class GroupActivity : AppCompatActivity() {
    lateinit var groupAdapter: GroupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)
        val database=AppDataBase.getInstance().getGroupDao()
        val get = intent.getIntExtra("id", 0)
        groups.text = "Groups :${database.getAllCourseById(get).size}"
        groupAdapter = GroupAdapter(database.getAllCourseById(get) as ArrayList<GroupEntity>, object : GroupAdapter.OnGroupClick {
            override fun onClick(course: GroupEntity) {
                var intent= Intent(this@GroupActivity,StudentActivity::class.java)
                intent.putExtra("groupId",course.id)
                startActivity(intent)

            }
        })
        group_rv.adapter = groupAdapter
        addGroup.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Guruh Qo`shish")
            var view = LayoutInflater.from(this).inflate(R.layout.dialog_view, null, false)
            view.titleDialog.hint="Guruh name"

            alert.setView(view)

            alert.setPositiveButton("Qo`shish",object : DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    if (view.titleDialog.text.toString().trim().isNotEmpty()){
                        var course= GroupEntity(name = view.titleDialog.text.toString(), byCourseId = get)
                        database.addGroup(course)
                        groupAdapter.clearItem(database.getAllCourseById(get) as ArrayList<GroupEntity>)
                        Toast.makeText(this@GroupActivity, "Saqlandi", Toast.LENGTH_SHORT).show()
                        groups.text = "Groups :${database.getAllCourseById(get).size}"

                    }
                    else{
                        Toast.makeText(this@GroupActivity, "Maydonlarni to`ldiring", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            })
            groupAdapter.clearItem(database.getAllCourseById(get) as ArrayList<GroupEntity>)

            alert.show() }

    }
}