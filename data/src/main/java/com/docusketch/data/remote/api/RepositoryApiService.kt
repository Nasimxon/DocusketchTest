package com.docusketch.data.remote.api

import com.docusketch.domain.model.ApiRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoryApiService {

    @GET("users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String
    ): Response<List<ApiRepository>>
}