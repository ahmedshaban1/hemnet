package com.example.hemnetapp.ui.screens.home.data.remote

import com.example.hemnetapp.models.HomeResponse

interface PropertyRemoteDataSource {
    suspend fun getHome(): HomeResponse
}
