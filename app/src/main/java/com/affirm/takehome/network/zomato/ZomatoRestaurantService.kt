package com.affirm.takehome.network.zomato

import com.affirm.takehome.BuildConfig
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

// Note: You could use this or define your own.
interface ZomatoRestaurantService {
    @GET("search")
    @Headers("user-key: ${BuildConfig.ZOMATO_USER_KEY}")
    fun getZomatoRestaurants(@Query("lat") latitude: Double, @Query("lon") longitude: Double, @Query("start") offset: Int = 0): Single<ZomatoResponse>

    companion object {
        fun create(): ZomatoRestaurantService {
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BuildConfig.ZOMATO_API_BASE_URL)
                .build()

            return retrofit.create(ZomatoRestaurantService::class.java)
        }
    }
}