package com.example.hemnetapp.ui.screens.home.data.repo

import com.example.hemnetapp.ui.screens.home.data.remote.PropertyRemoteDataSource
import com.example.hemnetapp.ui.screens.home.domain.repo.PropertyRepository
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(private val remote: PropertyRemoteDataSource) :
    PropertyRepository {
    override suspend fun getHome(): String {
        return remote.getHome()
    }
}
