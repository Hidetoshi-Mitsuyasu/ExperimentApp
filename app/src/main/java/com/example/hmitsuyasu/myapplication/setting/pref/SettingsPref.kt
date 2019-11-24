package com.example.hmitsuyasu.myapplication.setting.pref

import android.content.Context
import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository

open class SettingsPref(mContext: Context) : ISettingRepository {
    override fun getPh2OtaAvailableOn(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true
    }
}
