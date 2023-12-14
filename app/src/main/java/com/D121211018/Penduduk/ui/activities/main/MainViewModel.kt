package com.D121211018.Makanan.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211018.Makanan.data.models.ExtendedIngredient
import com.D121211018.Makanan.data.repository.MakananRepository
import com.D121211018.Makanan.MyApplication
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val makanan: List<String>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}


class MainViewModel(private val ingredient: MakananRepository): ViewModel() {

    // initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getIngredient() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            // Ganti dengan pemanggilan API yang sesuai
            val result = MakananRepository.ExtendedIngredient("apples,flour,sugar", 2)
            Log.d("MainViewModel", "getIngredient: ${result.size}")
            mainUiState = MainUiState.Success(result)
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    // block yg pertama dipanggil ktika ini dibuka
    init {
        getIngredient()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val MakananRepository = application.container.MakananRepository
                MainViewModel(MakananRepository)
            }
        }
    }
}