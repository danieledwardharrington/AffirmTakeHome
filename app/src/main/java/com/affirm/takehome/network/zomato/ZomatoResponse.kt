package com.affirm.takehome.network.zomato

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ZomatoResponse (@SerializedName("restaurants")
                           @Expose
                           val restaurants: MutableList<ZomatoRestaurant>)