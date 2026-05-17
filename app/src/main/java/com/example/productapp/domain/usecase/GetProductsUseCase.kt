package com.example.productapp.domain.usecase

import androidx.paging.PagingData
import com.example.productapp.domain.model.Product
import com.example.productapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(query: String? = null): Flow<PagingData<Product>> {
        return repository.getPagedProducts(query)
    }
}