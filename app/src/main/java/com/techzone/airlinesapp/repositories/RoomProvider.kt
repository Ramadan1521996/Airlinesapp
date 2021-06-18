package com.techzone.airlinesapp.repositories

import androidx.lifecycle.MutableLiveData
import com.techzone.airlinesapp.airline_room.AirlineDataBase
import com.techzone.airlinesapp.models.Airline
import com.techzone.airlinesapp.util.HelperClass
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class RoomProvider  {
    private val mutableLiveDataAirlinesList: MutableLiveData<List<Airline>> = MutableLiveData<List<Airline>>()
    private val mutableLiveDataAirline: MutableLiveData<Airline> = MutableLiveData<Airline>()
    private val airlineDataBase: AirlineDataBase = AirlineDataBase.getInstance(HelperClass.applicationContext!!)!!

    fun getAirlinesList(): MutableLiveData<List<Airline>> {
        airlineDataBase.airlineDao()!!.getAllAirlines()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<List<Airline>> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onSuccess(airlines: List<Airline>) {
                        mutableLiveDataAirlinesList.setValue(airlines)
                    }

                    override fun onError(e: Throwable) {}
                })
        return mutableLiveDataAirlinesList
    }

    fun getAirline(id: String): MutableLiveData<Airline>? {
        airlineDataBase.airlineDao()!!.getAirlineById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Airline> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onSuccess(airline: Airline) {
                        mutableLiveDataAirline.value = airline
                    }

                    override fun onError(e: Throwable) {}
                })
        return mutableLiveDataAirline
    }

    fun deleteAll(): Completable? {
        return airlineDataBase.airlineDao()!!.deleteAll()
    }

    fun insertAll(airlines: List<Airline>) {
        airlineDataBase.airlineDao()!!.insertAll(airlines)
                .subscribeOn(Schedulers.computation())
                .subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onComplete() {}
                    override fun onError(e: Throwable) {}
                })
    }
}