package com.example.hemnetapp.ui.screens.home.data.remote

interface PropertyRemoteDataSource {
    suspend fun getHome(): String
}
