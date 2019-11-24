package com.example.hmitsuyasu.myapplication.pref

import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository

open class SettingsPrefTestImp() : ISettingRepository {

    private var ph2OtaAvailableOn: Boolean = false

    override fun getPh2OtaAvailableOn(): Boolean {
        return ph2OtaAvailableOn
    }

    fun setPh2OtaAvailableOn(boolean: Boolean) {
        ph2OtaAvailableOn = boolean
    }
}
