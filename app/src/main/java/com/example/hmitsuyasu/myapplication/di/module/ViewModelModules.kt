package com.example.hmitsuyasu.myapplication.di.module

import com.example.hmitsuyasu.myapplication.models.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModules = module {
    viewModel {
        LoginViewModel(get())
    }
}