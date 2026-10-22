package skdevicehub.smartphones.pockettechcart.data.repository

import skdevicehub.smartphones.pockettechcart.data.model.Product
import skdevicehub.smartphones.pockettechcart.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(

    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
