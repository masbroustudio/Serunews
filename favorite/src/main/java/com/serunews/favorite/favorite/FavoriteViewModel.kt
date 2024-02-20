package com.serunews.favorite.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.serunews.core.domain.usecase.NewsTechUseCase

class FavoriteViewModel(newsTechUseCase: NewsTechUseCase) : ViewModel() {
    val favoriteNewsTech = newsTechUseCase.getFavoriteNewsTech().asLiveData()
}