package com.example.hmitsuyasu.myapplication.update.usecase

import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository

class UseCaseUpdate(
    private val setteig: ISettingRepository
//        private val remoteConfig: IOnTheAirSettingRepository
) {

    enum class ServerName(private val code: String) {
        OTA("OTA"),
        S3("S3")
    }

    fun getDownloadServer(
    ): ServerName {
//        if (setteig.getPh2OtaAvailableOn() && remoteConfig.isOtaUpdateEnabled) {
        if (setteig.getPh2OtaAvailableOn()) {
            return ServerName.OTA
        } else {
            return ServerName.S3
        }
    }
}