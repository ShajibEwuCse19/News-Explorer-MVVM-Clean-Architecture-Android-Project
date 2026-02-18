package com.example.mvvm_using_kotlin

import android.app.Application
import com.example.mvvm_using_kotlin.di.component.ApplicationComponent
import com.example.mvvm_using_kotlin.di.component.DaggerApplicationComponent
import com.example.mvvm_using_kotlin.di.module.ApplicationModule

/**
 * @author Shajib
 * since 2/18/26
 */
class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}