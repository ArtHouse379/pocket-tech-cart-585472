package skdevicehub.smartphones.pockettechcart.di

import skdevicehub.smartphones.pockettechcart.data.repository.CartRepository
import skdevicehub.smartphones.pockettechcart.data.repository.OnboardingRepository
import skdevicehub.smartphones.pockettechcart.data.repository.OrderRepository
import skdevicehub.smartphones.pockettechcart.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        OnboardingRepository(
            onboardingDataStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}