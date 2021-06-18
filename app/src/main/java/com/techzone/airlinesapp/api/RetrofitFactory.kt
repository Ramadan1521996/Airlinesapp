package com.techzone.airlinesapp.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    //private static final String BASE_URL = "https://r-write.com/laravelfirebase/public/api/";
    companion object {
        private val BASE_URL = "https://api.instantwebtools.net/v1/"
        fun  getRetrofitInstance(): Retrofit {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                val client: OkHttpClient = OkHttpClient.Builder()
//                        .addInterceptor(logging)
//                        .build()
               var retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                       // .client(client)
                        .build()
            return retrofit
        }
    }

}