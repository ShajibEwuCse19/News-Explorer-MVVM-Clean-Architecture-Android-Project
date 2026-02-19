package com.example.mvvm_using_kotlin.ui.topheadline.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_using_kotlin.data.model.Article
import com.example.mvvm_using_kotlin.data.repository.TopHeadlineRepository
import com.example.mvvm_using_kotlin.ui.base.UiState
import com.example.mvvm_using_kotlin.utils.AppConstant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

/**
 * @author Shajib
 * since 2/18/26
 */
class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(AppConstant.COUNTRY)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect { articles ->
                    _uiState.value = UiState.Success(articles)
                }
        }
    }

}