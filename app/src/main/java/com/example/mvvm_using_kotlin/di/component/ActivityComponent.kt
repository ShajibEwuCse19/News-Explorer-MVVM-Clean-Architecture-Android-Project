package com.example.mvvm_using_kotlin.di.component

import com.example.mvvm_using_kotlin.di.ActivityScope
import com.example.mvvm_using_kotlin.di.module.ActivityModule
import com.example.mvvm_using_kotlin.ui.topheadline.TopHeadlineActivity
import dagger.Component

/**
 * @author Shajib
 * since 2/18/26
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(activity: TopHeadlineActivity)
}