package com.tarun.demoapplication.network

import com.tarun.demoapplication.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface APIInterface {
    @GET("1gaa29")
    fun getData() : Observable<Response>
}