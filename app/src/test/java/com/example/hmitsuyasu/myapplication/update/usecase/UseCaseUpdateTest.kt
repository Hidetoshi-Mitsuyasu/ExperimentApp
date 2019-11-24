package com.example.hmitsuyasu.myapplication.update.usecase

import com.example.hmitsuyasu.myapplication.pref.SettingsPrefTestImp
import com.example.hmitsuyasu.myapplication.pref.SettingsPrefTestImp2
import com.example.hmitsuyasu.myapplication.update.repositories.ISettingRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject


class UseCaseUpdateTest : AutoCloseKoinTest() {
    private val repositoryModule: Module = module {
        factory { SettingsPrefTestImp() }
        single<ISettingRepository> {
            SettingsPrefTestImp()
        }
    }

    private val repositoryModuleTrue: Module = module {
        single<ISettingRepository> {
            SettingsPrefTestImp2()
        }
    }

    private val usecaseModule: Module = module {
        factory { UseCaseUpdate(get()) }
    }

    @Before
    fun before() {
        // You can start your Koin configuration
        startKoin { modules(listOf(usecaseModule)) }
    }

    // lazy inject BusinessService into property
    val usecase: UseCaseUpdate by inject()

    @Test
    fun getDownloadServer_001() {
        // or directly get any instance
        loadKoinModules(repositoryModuleTrue)
        assertThat(usecase.getDownloadServer(), `is`(UseCaseUpdate.ServerName.OTA))
    }

    @Test
    fun getDownloadServer_002() {
        // or directly get any instance
        loadKoinModules(repositoryModule)
        assertThat(usecase.getDownloadServer(), `is`(UseCaseUpdate.ServerName.S3))
    }

    @Test
    fun getDownloadServer() {
    }
}