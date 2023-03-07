package com.docusketch.data.remote.api

import com.docusketch.domain.model.ApiUser
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersApiService {

    @GET("users")
    suspend fun getAllUsers(
        @Query("since") id: Int = 1,
        @Query("per_page") perPage: Int = 30
    ) : Response<List<ApiUser>>

    @GET("users/{username}")
    suspend fun getUserInfo(
        @Path("username") username: String
    ): Response<ApiUser>
}