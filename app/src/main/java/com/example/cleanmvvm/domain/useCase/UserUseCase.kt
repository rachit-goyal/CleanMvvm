package com.example.cleanmvvm.domain.useCase

import com.example.cleanmvvm.data.model.UserResponse

interface UserUseCase {
    suspend fun getUserData(): UserResponse
}