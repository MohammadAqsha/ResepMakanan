package com.D121211018.Makanan.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211018.Makanan.data.repository.MakananRepository
import com.D121211018.Makanan.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val makananRepository: MakananRepository
}

class DefaultAppContainer : AppContainer {

    private val BASE_URL = "https://api.spoonacular.com/recipes/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val makananRepository: MakananRepository
        get() = MakananRepository(retrofitService)
}
