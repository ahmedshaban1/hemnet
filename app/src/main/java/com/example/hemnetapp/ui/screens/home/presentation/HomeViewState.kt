package com.example.hemnetapp.ui.screens.home.presentation

import com.example.hemnetapp.models.PropertyModel

data class HomeViewState(
    val homeList: List<PropertyModel> = listOf(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)
