package com.serunews.core.domain.usecase


import com.serunews.core.domain.model.NewsTech
import kotlinx.coroutines.flow.Flow

interface NewsTechUseCase {

    fun getAllNewsTech(): Flow<com.serunews.core.source.Resource<List<NewsTech>>>

    fun getFavoriteNewsTech(): Flow<List<NewsTech>>

    fun setFavoriteNewsTech(newsTech: NewsTech, state: Boolean)

}