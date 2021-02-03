package com.affirm.takehome.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RestaurantViewModelFactory(application: Application): ViewModelProvider.Factory {

    private var mApplication = application

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return RestaurantViewModel(mApplication) as T
    }
}