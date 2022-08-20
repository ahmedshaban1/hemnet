package com.example.hemnetapp.ui.screens.home.data.remote

import com.example.hemnetapp.models.HomeResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface HemnetApi {

    @Headers("mock:true")
    @GET("/home")
    suspend fun getHome(): HomeResponse
}
