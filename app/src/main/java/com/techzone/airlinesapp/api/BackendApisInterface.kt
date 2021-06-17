package com.techzone.airlinesapp.api

import com.techzone.airlinesapp.models.Airline
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BackendApisInterface {
    @GET("airlines")
    fun getAirlinesList(): Single<List<Airline>>

    @GET("airlines/{id}")
    fun getAirlineById(@Path("id") id: String): Single<Airline>
}