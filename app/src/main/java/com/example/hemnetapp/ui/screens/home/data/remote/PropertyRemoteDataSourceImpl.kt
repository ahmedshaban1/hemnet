package com.example.hemnetapp.ui.screens.home.data.remote

import com.example.hemnetapp.models.HomeResponse
import javax.inject.Inject

class PropertyRemoteDataSourceImpl @Inject constructor(private val api: HemnetApi) :
    PropertyRemoteDataSource {
    override suspend fun getHome(): HomeResponse {
        return api.getHome()
    }
}
