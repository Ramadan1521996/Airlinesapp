package com.techzone.airlinesapp.repositories

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.MutableLiveData
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.util.HelperClass
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AirlineRepository {
    private var apiProvider: ApiProvider? = null
    private var roomProvider: RoomProvider? = null

    fun getAirlinesList(): MutableLiveData<List<Airline>>? {
        // Get a reference to the ConnectivityManager to check state of network connectivity

        // Get a reference to the ConnectivityManager to check state of network connectivity
        val connMgr = HelperClass.applicationContext!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Get details on the currently active default data network
        // Get details on the currently active default data network
        val networkInfo = connMgr.activeNetworkInfo

        // If there is a network connection, fetch data

        // If there is a network connection, fetch data
        return if (networkInfo != null && networkInfo.isConnected) {
            if (apiProvider == null) {
                apiProvider = ApiProvider()
            }
            apiProvider!!.getAirlinesList()!!.observeForever { airlines ->
                if (roomProvider == null) {
                    roomProvider = RoomProvider()
                }
                roomProvider!!.deleteAll()!!
                        .subscribeOn(Schedulers.computation())
                        .subscribe(object : CompletableObserver {
                            override fun onSubscribe(d: Disposable) {}
                            override fun onComplete() {
                                roomProvider!!.insertAll(airlines.subList(0, 10))
                            }

                            override fun onError(e: Throwable) {}
                        })
            }
            apiProvider!!.getAirlinesList()
        } else {
            if (roomProvider == null) {
                roomProvider = RoomProvider()
            }
            roomProvider!!.getAirlinesList()
        }
    }

    fun getAirline(id: String): MutableLiveData<Airline>? {
        // Get a reference to the ConnectivityManager to check state of network connectivity

        // Get a reference to the ConnectivityManager to check state of network connectivity
        val connMgr = HelperClass.applicationContext!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Get details on the currently active default data network
        // Get details on the currently active default data network
        val networkInfo = connMgr.activeNetworkInfo

        // If there is a network connection, fetch data

        // If there is a network connection, fetch data
        return if (networkInfo != null && networkInfo.isConnected) {
            if (apiProvider == null) {
                apiProvider = ApiProvider()
            }
            apiProvider!!.getAirline(id)
        } else {
            if (roomProvider == null) {
                roomProvider = RoomProvider()
            }
            roomProvider!!.getAirline(id)
        }
    }
}