package com.example.hemnetapp.ui.screens.home.domain.repo

import com.example.hemnetapp.models.HomeResponse

interface PropertyRepository {
    suspend fun getHome(): HomeResponse
}
