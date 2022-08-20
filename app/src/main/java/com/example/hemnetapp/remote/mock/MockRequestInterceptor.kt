package com.example.hemnetapp.remote.mock

import android.content.Context
import com.example.hemnetapp.helpers.readFileFromAssets
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import javax.inject.Inject

class MockRequestInterceptor @Inject constructor(@ApplicationContext private val context: Context) : Interceptor {

    companion object {
        private val JSON_MEDIA_TYPE = MediaType.parse("application/json")
        private const val MOCK = "mock"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val header = request.header(MOCK)

        if (header != null) {
            val filename = request.url().pathSegments().last()
            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .message("")
                .code(200)
                .body(ResponseBody.create(JSON_MEDIA_TYPE, context.readFileFromAssets("mocks/$filename.json")))
                .build()
        }

        return chain.proceed(request.newBuilder().removeHeader(MOCK).build())
    }
}