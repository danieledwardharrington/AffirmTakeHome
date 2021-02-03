package com.affirm.takehome.network.zomato

import retrofit2.Call

class ZomatoRestaurantApi(private val restaurantService: ZomatoRestaurantService) {
/*    fun getRestaurants(latitude: Double, longitude: Double, offset: Int): Call<ZomatoResponse> {
        return restaurantService.getZomatoRestaurants(USER_KEY, latitude, longitude, offset)
    }*/

    companion object {
        private const val USER_KEY = "267d43cc8c37370c833845613671f303"
    }
}