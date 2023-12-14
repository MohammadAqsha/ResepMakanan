package com.D121211018.Makanan.data.source.remote

import com.D121211018.Makanan.data.response.GetResepResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // Endpoint Pertama
    @GET("recipes/information")
    suspend fun getRecipeInformation(
        @Query("apiKey") apiKey: String,
        @Query("includeNutrition") includeNutrition: Boolean
    ): GetResepResponse // Ganti dengan nama model yang sesuai

    // Endpoint Kedua
    @GET("recipes/findByIngredients")
    suspend fun findRecipesByIngredients(
        @Query("ingredients") ingredients: String,
        @Query("number") number: Int
    ): List<String> // Ganti dengan nama model yang sesuai
}
