package com.affirm.takehome.repository.pagingsource

import android.util.Log
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.affirm.takehome.network.yelp.YelpRestaurant
import com.affirm.takehome.network.yelp.YelpRestaurantService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

private const val REMOTE_STARTING_PAGE_INDEX = 1
private const val TAG = "ZomatoPagingSource"

class YelpPagingSource(private val yelpService: YelpRestaurantService, private val lat: Double, private val lon: Double, private val offset: Int):
    RxPagingSource<Int, YelpRestaurant>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, YelpRestaurant>> {
        Log.d(TAG, "LoadSingle")
        val position = params.key ?: REMOTE_STARTING_PAGE_INDEX

        return yelpService.getYelpRestaurants(lat, lon, offset).subscribeOn(Schedulers.io()).map {
            LoadResult.Page(
                data = it.restaurants,
                prevKey = if (position == REMOTE_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (it.restaurants.isEmpty()) null else position + 1
            ) as LoadResult<Int, YelpRestaurant>
        }.onErrorReturn {
            LoadResult.Error(it)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, YelpRestaurant>): Int? {
        return state.anchorPosition
    }
}