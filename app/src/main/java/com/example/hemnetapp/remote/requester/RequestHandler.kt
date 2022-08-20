package com.example.hemnetapp.remote.requester

import com.example.hemnetapp.remote.utilities.ResultWrapper

interface RequestHandler {
    suspend fun <T> makeApiRequest(
        call: suspend () -> T?
    ): ResultWrapper<T>
}
