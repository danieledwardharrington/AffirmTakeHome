package com.affirm.takehome.network.zomato

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ZomatoRestaurant(
    @SerializedName("restaurant")
    @Expose
    val restaurantDetail: ZomatoRestaurantDetail)

class ZomatoRestaurantDetail (
    @SerializedName("id")
    @Expose
    val id: String = "",
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("featured_image")
    @Expose
    val image: String,
    @SerializedName("user_rating")
    @Expose
    val userRating: UserRating)

data class UserRating(
    @SerializedName("aggregate_rating")
    @Expose
    val rating: String)
