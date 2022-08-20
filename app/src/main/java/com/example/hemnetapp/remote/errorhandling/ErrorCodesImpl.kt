package com.example.hemnetapp.remote.errorhandling

import android.content.res.Resources
import com.example.hemnetapp.R
import com.example.hemnetapp.remote.errorhandling.ErrorCodes.GENERIC_ERROR
import com.example.hemnetapp.remote.errorhandling.ErrorCodes.NO_DATA_FOUND

class ErrorCodesImpl(private val res: Resources) : IErrorCodes {
    override fun getMessage(errorCode: Int): String {
        return when (errorCode) {
            NO_DATA_FOUND -> res.getString(R.string.no_data_found)
            GENERIC_ERROR -> res.getString(R.string.generic_error)
            else -> res.getString(R.string.generic_error)
        }
    }
}
