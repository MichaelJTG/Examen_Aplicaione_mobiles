package com.example.examen_2.data.repository

import com.example.examen_2.data.model.ProductosDto
import com.example.examen_2.data.remote.ProductosAPI

class ProductosRepository(private val api: ProductosAPI) {

    suspend fun getProducts(page: Int = 1): List<ProductosDto> =
        api.getProducts(page).results
    
}