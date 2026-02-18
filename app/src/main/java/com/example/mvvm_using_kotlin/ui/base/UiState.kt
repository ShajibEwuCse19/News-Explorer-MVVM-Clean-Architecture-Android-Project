package com.example.mvvm_using_kotlin.ui.base

/**
 * @author Shajib
 * since 2/18/26
 */
sealed interface UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    object Loading : UiState<Nothing>
}