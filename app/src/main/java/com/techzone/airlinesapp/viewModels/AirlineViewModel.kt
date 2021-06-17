package com.techzone.airlinesapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.repositories.AirlineRepository

class AirlineViewModel : ViewModel() {
    private var airlineRepository: AirlineRepository? = null

    fun getAirlinesList(): LiveData<List<Airline>>? {
        if (airlineRepository == null) {
            airlineRepository = AirlineRepository()
        }
        return airlineRepository!!.getAirlinesList()
    }

    fun getAirline(id: String): MutableLiveData<Airline>? {
        if (airlineRepository == null) {
            airlineRepository = AirlineRepository()
        }
        return airlineRepository!!.getAirline(id)
    }
}