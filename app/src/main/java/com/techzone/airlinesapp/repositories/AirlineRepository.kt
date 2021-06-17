package com.techzone.airlinesapp.repositories

import androidx.lifecycle.MutableLiveData
import com.techzone.airlinesapp.api.ApiProvider
import com.techzone.airlinesapp.models.Airline

class AirlineRepository {
    private var apiProvider: ApiProvider? = null

    fun getAirlinesList(): MutableLiveData<List<Airline>>? {
        if (apiProvider == null) {
            apiProvider = ApiProvider()
        }
        return apiProvider!!.getAirlinesList()
    }

    fun getAirline(id: String): MutableLiveData<Airline>? {
        if (apiProvider == null) {
            apiProvider = ApiProvider()
        }
        return apiProvider!!.getAirline(id)
    }
}