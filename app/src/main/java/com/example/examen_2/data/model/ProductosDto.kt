package com.example.examen_2.data.model

data class ProductosDto(
    val _id: String,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    val image: String,
    val active: Boolean
)

