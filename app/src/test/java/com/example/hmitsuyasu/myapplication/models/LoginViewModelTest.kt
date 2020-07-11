package com.example.hmitsuyasu.myapplication.models

import com.example.hmitsuyasu.myapplication.di.module.viewModelModules
import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class LoginViewModelTest : AutoCloseKoinTest() {

    private val repositoryTestModule: Module = module {
        single<ISettingRepository> {
            SettingsPrefMock()
        }
    }

    val loginViewModel: LoginViewModel by inject()

    @Before
    fun setUp() {
        startKoin { listOf(viewModelModules, repositoryTestModule) }
        loadKoinModules(listOf(viewModelModules, repositoryTestModule))
    }

    @Test
    fun isWithIn() {
        assertFalse(loginViewModel.isWithIn)
    }

    @Test
    fun getCurrentScore() {
    }

    @Test
    fun onUpdateCurrentScore() {
    }

    @Test
    fun getCurrentRanking() {
    }

    @Test
    fun getSettingRepository() {
    }

    open class SettingsPrefMock() : ISettingRepository {
        override fun getPh2OtaAvailableOn(): Boolean {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            return true
        }
    }
}