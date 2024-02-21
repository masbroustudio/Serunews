package com.serunews.core.source

import com.serunews.core.domain.model.NewsTech
import com.serunews.core.domain.repository.INewsTechRepository
import com.serunews.core.source.local.LocalDataSource
import com.serunews.core.source.remote.RemoteDataSource
import com.serunews.core.source.remote.network.ApiResponse
import com.serunews.core.source.remote.response.PostsItem
import com.serunews.core.utils.AppExecutors
import com.serunews.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewsTechRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : INewsTechRepository {

    override fun getAllNewsTech(): Flow<Resource<List<NewsTech>>> = object : NetworkBoundResource<List<NewsTech>, List<PostsItem>>(appExecutors){
        override fun loadFromDB(): Flow<List<NewsTech>> {
            return localDataSource.getAllNewsTech().map {
                DataMapper.mapEntitiesToDomain(it)
            }
        }

        override fun shouldFetch(data: List<NewsTech>?): Boolean {
            return data == null || data.isEmpty()
        }

        override suspend fun createCall(): Flow<ApiResponse<List<PostsItem>>> {
            return remoteDataSource.getAllNewsTech()
        }

        override suspend fun saveCallResult(data: List<PostsItem>) {
            val newsTechList = DataMapper.mapResponsesToEntities(data)
            localDataSource.insertNewsTech(newsTechList)
        }
    }.asFlow()

    override fun getFavoriteNewsTech(): Flow<List<NewsTech>> {
        return localDataSource.getFavoriteNewsTech().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteNewsTech(newsTech: NewsTech, state: Boolean) {
        val newsTechEntity = DataMapper.mapDomainToEntity(newsTech)
        appExecutors.diskIO().execute { localDataSource.setFavoriteNewsTech(newsTechEntity, state) }
    }

}