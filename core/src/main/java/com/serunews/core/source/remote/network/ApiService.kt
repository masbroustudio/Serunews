package com.serunews.core.source.remote.network

import com.serunews.core.source.remote.response.NewsTechResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("category/business/tech")
    suspend fun getNews(): NewsTechResponse
}