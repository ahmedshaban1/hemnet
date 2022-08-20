package com.example.hemnetapp.ui.screens.home.data.remote

import com.example.hemnetapp.ui.screens.home.data.remote.HemnetApi
import com.example.hemnetapp.ui.screens.home.data.remote.PropertyRemoteDataSource
import javax.inject.Inject

class PropertyRemoteDataSourceImpl @Inject constructor(private val api: HemnetApi) :
    PropertyRemoteDataSource {
    override suspend fun getHome(): String {
        return  api.getHome()
    }
}
