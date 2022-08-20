package com.example.hemnetapp.ui.screens.home.di

import com.example.hemnetapp.ui.screens.home.data.remote.HemnetApi
import com.example.hemnetapp.ui.screens.home.data.remote.PropertyRemoteDataSource
import com.example.hemnetapp.ui.screens.home.data.remote.PropertyRemoteDataSourceImpl
import com.example.hemnetapp.ui.screens.home.data.repo.PropertyRepositoryImpl
import com.example.hemnetapp.ui.screens.home.domain.repo.PropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PropertyModule {

    @Singleton
    @Provides
    fun providesPropertyRemoteDataSource(api: HemnetApi): PropertyRemoteDataSource =
        PropertyRemoteDataSourceImpl(api)

    @Singleton
    @Provides
    fun providesPropertyRepository(remoteDataSource: PropertyRemoteDataSource): PropertyRepository =
        PropertyRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun providesProApi(retrofit: Retrofit): HemnetApi =
        retrofit.create(HemnetApi::class.java)


}
