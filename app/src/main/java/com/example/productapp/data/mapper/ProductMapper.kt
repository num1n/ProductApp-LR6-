package com.example.productapp.data.mapper

import com.example.productapp.data.dto.ProductDto
import com.example.productapp.domain.model.Product

fun ProductDto.toDomain() = Product(
    id = id,
    name = title,
    price = price,
    imageUrl = thumbnail
)