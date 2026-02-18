package com.example.mvvm_using_kotlin.di

/**
 * @author Shajib
 * since 2/18/26
 */

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ActivityContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

