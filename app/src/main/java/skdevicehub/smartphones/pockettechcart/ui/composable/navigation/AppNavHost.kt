package skdevicehub.smartphones.pockettechcart.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.cart.UOWJDCartScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.checkout.UOWJDCheckoutScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.home.UOWJDHomeScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.onboarding.UOWJDOnboardingScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.order.UOWJDOrdersScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.productdetails.UOWJDProductDetailsScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.settings.UOWJDSettingsScreen
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.splash.UOWJDSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            UOWJDSplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            UOWJDOnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            UOWJDHomeScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                }
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            UOWJDProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            UOWJDCartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            UOWJDCheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            UOWJDOrdersScreen()
        }

        composable<NavRoute.Settings> {
            UOWJDSettingsScreen()
        }
    }
}