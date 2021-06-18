package com.techzone.airlinesapp.repositories

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.techzone.airlinesapp.api.BackendApisInterface
import com.techzone.airlinesapp.api.RetrofitFactory
import com.techzone.airlinesapp.models.Airline
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ApiProvider {
    private val mutableLiveDataAirlinesList: MutableLiveData<List<Airline>> = MutableLiveData<List<Airline>>()
    private val mutableLiveDataAirline: MutableLiveData<Airline> = MutableLiveData<Airline>()
    private val backendApi: BackendApisInterface = RetrofitFactory.getRetrofitInstance()
            .create(BackendApisInterface::class.java)

    @SuppressLint("CheckResult")
    fun getAirlinesList(): MutableLiveData<List<Airline>>? {
        backendApi.getAirlinesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    mutableLiveDataAirlinesList.setValue(response)
                }, { t -> })
        return mutableLiveDataAirlinesList
    }

    fun getAirline(id: String): MutableLiveData<Airline>? {
        backendApi.getAirlineById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Airline> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onSuccess(airline: Airline) {
                        mutableLiveDataAirline.setValue(airline)
                    }

                    override fun onError(e: Throwable) {}
                })
        return mutableLiveDataAirline
    }

}