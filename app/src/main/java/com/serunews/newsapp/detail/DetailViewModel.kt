package com.serunews.newsapp.detail

import androidx.lifecycle.ViewModel
import com.serunews.core.domain.model.NewsTech
import com.serunews.core.domain.usecase.NewsTechUseCase

class DetailViewModel(private val newsTechUseCase: NewsTechUseCase): ViewModel() {

    fun setFavoriteNewsTech(newsTechTittle: NewsTech, newStatus:Boolean) =
        newsTechUseCase.setFavoriteNewsTech(newsTechTittle, newStatus)
}