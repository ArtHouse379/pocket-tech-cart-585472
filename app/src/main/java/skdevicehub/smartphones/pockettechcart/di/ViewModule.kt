package skdevicehub.smartphones.pockettechcart.di

import skdevicehub.smartphones.pockettechcart.ui.viewmodel.AppViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.CartViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.CheckoutViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.OnboardingViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.OrderViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.ProductDetailsViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.ProductViewModel
import skdevicehub.smartphones.pockettechcart.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}