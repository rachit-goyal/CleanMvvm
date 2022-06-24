package com.example.cleanmvvm.data.repository

import com.example.cleanmvvm.data.model.UserResponse
import com.example.cleanmvvm.data.network.SafeApiRequest
import com.example.cleanmvvm.data.network.UserApiClient
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApiClient: UserApiClient) :
    SafeApiRequest() {
    suspend fun getUserdata(): UserResponse {
        return apiRequest { userApiClient.getUserData() }
    }
}