package com.example.examen_2.data.remote

import com.example.examen_2.data.model.PagedResponse
import com.example.examen_2.data.model.ProductosDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductosAPI {
    @GET("products")
    suspend fun getProducts(
        @Query("page") page: Int = 1
    ): PagedResponse<ProductosDto>
}