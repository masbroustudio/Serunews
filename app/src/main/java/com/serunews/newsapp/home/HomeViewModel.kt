package com.serunews.newsapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.serunews.core.domain.usecase.NewsTechUseCase

class HomeViewModel(newsTechUseCase: NewsTechUseCase) : ViewModel() {
    val newsTech = newsTechUseCase.getAllNewsTech().asLiveData()
}