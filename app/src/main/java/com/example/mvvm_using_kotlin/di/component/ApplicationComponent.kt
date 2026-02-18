package com.example.mvvm_using_kotlin.di.component

import android.content.Context
import com.example.mvvm_using_kotlin.MVVMApplication
import com.example.mvvm_using_kotlin.data.api.NetworkService
import com.example.mvvm_using_kotlin.data.repository.TopHeadlineRepository
import com.example.mvvm_using_kotlin.di.ApplicationContext
import com.example.mvvm_using_kotlin.di.module.ApplicationModule
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * @author Shajib
 * since 2/18/26
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository
}