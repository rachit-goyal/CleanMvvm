package com.example.cleanmvvm.data.network

import com.example.cleanmvvm.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("/api/users/5")
    suspend fun getUserData():Response<UserResponse>
}