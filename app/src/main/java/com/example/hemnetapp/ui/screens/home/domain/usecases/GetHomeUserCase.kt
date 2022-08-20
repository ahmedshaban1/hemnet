package com.example.hemnetapp.ui.screens.home.domain.usecases

import com.example.hemnetapp.remote.requester.RequestHandler
import com.example.hemnetapp.remote.utilities.Resource
import com.example.hemnetapp.remote.utilities.ResultWrapper
import com.example.hemnetapp.ui.screens.home.domain.repo.PropertyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeUserCase @Inject constructor(
    private val repository: PropertyRepository,
    private val requestHandler: RequestHandler
) : RequestHandler by requestHandler {

    suspend operator fun invoke() = flow {
        emit(Resource.Loading)
        val results = requestHandler.makeApiRequest {
            repository.getHome()
        }
        when (results) {
            is ResultWrapper.GenericError -> emit(Resource.Error(results.errorCode))
            is ResultWrapper.Success -> emit(
                Resource.Success(
                    results.value
                )
            )
        }
    }
}
