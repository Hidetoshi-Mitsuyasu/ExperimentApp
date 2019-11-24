package com.example.hmitsuyasu.myapplication.di.module

import com.example.hmitsuyasu.myapplication.setting.pref.SettingsPref
import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository
import com.example.hmitsuyasu.myapplication.update.usecase.UseCaseUpdate
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val preferencesModules = module {
    single {
        UseCaseUpdate(get())
    }
    single<ISettingRepository> {
        SettingsPref(androidApplication())
    }
}