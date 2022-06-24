package com.example.cleanmvvm.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanmvvm.data.model.Failed
import com.example.cleanmvvm.data.model.Success
import com.example.cleanmvvm.data.model.UIState
import com.example.cleanmvvm.domain.useCaseImpl.UserUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCaseImpl: UserUseCaseImpl) : ViewModel() {
    val userData: MutableLiveData<UIState> = MutableLiveData()
    val progress = MutableLiveData<Boolean>()

    fun getUserData() {
        progress.value = true
        viewModelScope.launch {
            try {
                val response = useCaseImpl.getUserData()
                userData.value = Success(response)
                progress.value = false
            } catch (e: Exception) {
                e.message?.let {
                    userData.value = Failed(it)
                }
                progress.value = false
            }
        }
    }
}