package com.example.mvvm_using_kotlin.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_using_kotlin.data.repository.TopHeadlineRepository
import com.example.mvvm_using_kotlin.di.ActivityContext
import com.example.mvvm_using_kotlin.ui.base.ViewModelProviderFactory
import com.example.mvvm_using_kotlin.ui.topheadline.TopHeadlineAdapter
import com.example.mvvm_using_kotlin.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

/**
 * @author Shajib
 * since 2/18/26
 */
@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel {
        return ViewModelProvider(
            activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}