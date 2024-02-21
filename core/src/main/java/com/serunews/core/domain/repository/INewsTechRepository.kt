package com.serunews.core.domain.repository

import com.serunews.core.domain.model.NewsTech
import kotlinx.coroutines.flow.Flow

interface INewsTechRepository {

    fun getAllNewsTech(): Flow<com.serunews.core.source.Resource<List<NewsTech>>>

    fun getFavoriteNewsTech(): Flow<List<NewsTech>>

    fun setFavoriteNewsTech(newsTech: NewsTech, state: Boolean)
}