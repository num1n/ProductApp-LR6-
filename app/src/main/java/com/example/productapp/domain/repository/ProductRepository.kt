package com.example.productapp.domain.repository

import androidx.paging.PagingData
import com.example.productapp.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getPagedProducts(query: String? = null): Flow<PagingData<Product>>
}