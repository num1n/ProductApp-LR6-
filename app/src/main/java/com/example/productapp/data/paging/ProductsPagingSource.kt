package com.example.productapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.productapp.data.mapper.toDomain
import com.example.productapp.data.network.ApiService
import com.example.productapp.domain.model.Product

class ProductsPagingSource(
    private val api: ApiService,
    private val query: String? = null
) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val page = params.key ?: 0
            val response = if (query.isNullOrBlank()) {
                api.getProducts(limit = params.loadSize, skip = page)
            } else {
                api.searchProducts(query = query, limit = params.loadSize, skip = page)
            }
            val data = response.products.map { it.toDomain() }
            LoadResult.Page(
                data = data,
                prevKey = if (page == 0) null else page - params.loadSize,
                nextKey = if (data.isEmpty()) null else page + params.loadSize
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition
    }
}