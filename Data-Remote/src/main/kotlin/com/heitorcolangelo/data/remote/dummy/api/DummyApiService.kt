package com.heitorcolangelo.data.remote.dummy.api

import com.heitorcolangelo.data.remote.common.api.ApiService
import com.heitorcolangelo.data.remote.dummy.model.DummiesResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface DummyApiService {
    companion object {
        const val BASE_URL = "${ApiService.BASE_URL}/dummy"
    }

    @GET("/dummies")
    fun getDummies(): Observable<DummiesResponseModel>

    @GET("/dummies")
    fun getDummies2(): Observable<DummiesResponseModel>
}
