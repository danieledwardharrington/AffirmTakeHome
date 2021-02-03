package com.affirm.takehome.network.yelp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YelpRestaurant(
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("image_url")
    @Expose
    val image: String,
    @SerializedName("rating")
    @Expose
    val rating: String)