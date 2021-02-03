package com.affirm.takehome.network.zomato

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

private const val ZOMATO_API_BASE_URL = "https://developers.zomato.com/api/v2.1/"

class ZomatoRestaurantApiFactory {
    companion object {
        fun create(): ZomatoRestaurantApi {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val contentType = "application/json".toMediaType()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(Json(JsonConfiguration(ignoreUnknownKeys = true, isLenient = true)).asConverterFactory(contentType))
                .baseUrl(ZOMATO_API_BASE_URL)
                .client(httpClient.build())
                .build()

            return ZomatoRestaurantApi(retrofit.create(ZomatoRestaurantService::class.java))
        }
    }
}