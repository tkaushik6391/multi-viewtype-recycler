package com.tarun.demoapplication.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebAPI {
    companion object {
        var BASE_URL = "https://api.myjson.com/bins/"
        private var retrofit: Retrofit? = null
        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    ?.addConverterFactory(GsonConverterFactory.create())
                    ?.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    ?.baseUrl(BASE_URL)
                    ?.build()
            }
            return retrofit
        }
    }
}