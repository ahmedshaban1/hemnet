package com.example.hemnetapp.ui.screens.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hemnetapp.remote.errorhandling.IErrorCodes
import com.example.hemnetapp.remote.utilities.Resource
import com.example.hemnetapp.ui.screens.home.domain.usecases.GetHomeUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val errorCodes: IErrorCodes,
    private val getHomeUserCase: GetHomeUserCase,
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState = _viewState.asStateFlow()

    init {
        getHome()
    }

    private fun getHome() {
        viewModelScope.launch {
            getHomeUserCase().collectLatest { results ->
                when (results) {
                    is Resource.Error -> _viewState.update { state ->
                        state.copy(
                            errorMessage = errorCodes.getMessage(
                                results.errorCode
                            ),
                            isLoading = false
                        )
                    }
                    Resource.Loading -> _viewState.update { state ->
                        state.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success -> _viewState.update { state ->
                        state.copy(
                            isLoading = false,
                            homeList = results.data ?: ""
                        )
                    }
                }
            }
        }
    }

}
