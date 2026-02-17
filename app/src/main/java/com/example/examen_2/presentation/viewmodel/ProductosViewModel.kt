package com.example.examen_2.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen_2.data.model.ProductosDto
import com.example.examen_2.data.remote.ProductosNetWork
import com.example.examen_2.data.repository.ProductosRepository
import kotlinx.coroutines.launch

class ProductosViewModel : ViewModel() {
    private val repository = ProductosRepository(ProductosNetWork.api)

    var state by mutableStateOf<UiState<List<ProductosDto>>>(UiState.Loading)
        private set

    init {
        loadProductos()
    }

    fun loadProductos() {
        viewModelScope.launch {
            state = UiState.Loading
            state = try {
                UiState.Success(repository.getProducts())

            } catch (e: Exception) {
                UiState.Error(msg = e.message ?: "Error cargando Productos")
            }
        }
    }
}