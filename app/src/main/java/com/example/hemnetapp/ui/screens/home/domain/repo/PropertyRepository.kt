package com.example.hemnetapp.ui.screens.home.domain.repo

interface PropertyRepository {
    suspend fun getHome(): String
}
