package com.serunews.core.utils

import com.serunews.core.source.remote.response.PostsItem
import com.serunews.core.domain.model.IndoNews
import com.serunews.core.source.local.entity.NewsIndoEntity


object DataMapper {
    fun mapResponsesToEntities(input: List<PostsItem>): List<NewsIndoEntity> {
        val newsTechList = ArrayList<NewsIndoEntity>()
        input.map {
            val newsTech = NewsIndoEntity(
                title = it.title,
                category = it.category,
                headline = it.headline,
                image = it.image,
                premiumBadge = it.premiumBadge,
                pusblisedAt = it.pusblisedAt,
                link = it.link,
                isFavorite = false
            )
            newsTechList.add(newsTech)
        }
        return newsTechList
    }

    fun mapEntitiesToDomain(input: List<NewsIndoEntity>): List<IndoNews> =
        input.map {
            IndoNews(
                title = it.title,
                category = it.category,
                headline = it.headline,
                image = it.image,
                premiumBadge = it.premiumBadge,
                pusblisedAt = it.pusblisedAt,
                link = it.link,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: IndoNews) = NewsIndoEntity(
        title = input.title,
        category = input.category,
        headline = input.headline,
        image = input.image,
        premiumBadge = input.premiumBadge,
        pusblisedAt = input.pusblisedAt,
        link = input.link,
        isFavorite = input.isFavorite
    )
}