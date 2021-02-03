package com.affirm.takehome.network.yelp

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
interface YelpRestaurantService {
    @GET("v3/businesses/search")
    @Headers("Authorization: ${BuildConfig.YELP_TOKEN}")
    fun getYelpRestaurants(@Query("latitude") latitude: Double, @Query("longitude") longitude: Double, @Query("offset") offset: Int = 0): Single<YelpResponse>

    companion object {
        fun create(): YelpRestaurantService {
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BuildConfig.YELP_API_BASE_URL)
                .build()

            return retrofit.create(YelpRestaurantService::class.java)
        }
    }

}