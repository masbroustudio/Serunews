package com.serunews.newsapp.di


import com.serunews.core.domain.usecase.NewsTechInteracator
import com.serunews.core.domain.usecase.NewsTechUseCase
import com.serunews.newsapp.detail.DetailViewModel
import com.serunews.newsapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<NewsTechUseCase> { NewsTechInteracator(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}