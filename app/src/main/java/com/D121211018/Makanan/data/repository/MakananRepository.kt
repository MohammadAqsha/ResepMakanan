package com.D121211018.Makanan.data.repository

import com.D121211018.Makanan.data.response.GetResepResponse
import com.D121211018.Makanan.data.source.remote.ApiService
import com.D121211018.Makanan.data.models.ExtendedIngredient
import retrofit2.http.Query

class MakananRepository(private val apiService: ApiService) {

    // Menggunakan suspend function untuk melakukan pemanggilan API secara asynchronous
    suspend fun getRecipeInformation(apiKey: String, includeNutrition: Boolean): GetResepResponse {
        return apiService.getRecipeInformation(apiKey, includeNutrition)
    }

    suspend fun findRecipesByIngredients(ingredients: String, number: Int): List<String> {
        return apiService.findRecipesByIngredients(ingredients, number)
    }
}
