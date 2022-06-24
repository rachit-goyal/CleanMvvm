package com.example.cleanmvvm.domain.useCaseImpl

import com.example.cleanmvvm.data.model.UserResponse
import com.example.cleanmvvm.data.repository.UserRepository
import com.example.cleanmvvm.domain.useCase.UserUseCase
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    UserUseCase {
    override suspend fun getUserData(): UserResponse {
        return userRepository.getUserdata()
    }
}