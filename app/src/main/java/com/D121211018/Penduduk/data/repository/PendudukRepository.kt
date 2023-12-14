package com.D121211018.Penduduk.data.repository

import com.D121211018.Penduduk.data.response.GetResepResponse
import com.D121211018.Penduduk.data.source.remote.ApiService

class MakananRepository(private val apiService: ApiService) {

    // Menggunakan suspend function untuk melakukan pemanggilan API secara asynchronous
    suspend fun getRecipeInformation(apiKey: String, includeNutrition: Boolean): GetResepResponse {
        return apiService.getRecipeInformation(apiKey, includeNutrition)
    }

    suspend fun findRecipesByIngredients(ingredients: String, number: Int): List<String> {
        return apiService.findRecipesByIngredients(ingredients, number)
    }
}
