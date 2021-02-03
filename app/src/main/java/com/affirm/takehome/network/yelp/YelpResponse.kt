package com.affirm.takehome.network.yelp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class YelpResponse(@SerializedName("businesses")
                        @Expose
                        val restaurants: MutableList<YelpRestaurant>)