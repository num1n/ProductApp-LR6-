package com.example.productapp.data.dto

import com.squareup.moshi.Json

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val thumbnail: String
)

data class ProductsResponse(
    val products: List<ProductDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)