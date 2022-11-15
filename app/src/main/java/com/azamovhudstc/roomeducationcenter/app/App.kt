package com.azamovhudstc.roomeducationcenter.app

import android.app.Application
import com.azamovhudstc.roomeducationcenter.db.AppDataBase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        AppDataBase.init(this)
    }
}