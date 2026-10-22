package skdevicehub.smartphones.pockettechcart.ui.composable.approot.bottombar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.bottombar.BottomNavItem
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.bottombar.isSelectedDestination
import skdevicehub.smartphones.pockettechcart.ui.composable.navigation.NavRoute
import skdevicehub.smartphones.pockettechcart.ui.theme.ControlDivider

@Composable
fun AppBottomBar(
    itemsInCart: Int,
    currentDestination: NavDestination?,
    navigationItems: List<BottomNavItem>,
    onNavigateToRoute: (BottomNavItem) -> Unit,
) {
    Column {
        ControlDivider()

        NavigationBar(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary,
        ) {
            navigationItems.forEach { item ->
                NavigationBarItem(
                    selected = isSelectedDestination(currentDestination, item.route),
                    onClick = { onNavigateToRoute(item) },
                    icon = {
                        if (item.route == NavRoute.Cart) {
                            BadgedBox(
                                badge = {
                                    if (itemsInCart > 0) {
                                        Badge {
                                            Text(itemsInCart.toString())
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = stringResource(item.titleRes),
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = stringResource(item.titleRes),
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    },
                    label = {
                        Text(text = stringResource(item.titleRes))
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        selectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        selectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f),
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f),
                    )
                )
            }
        }
    }
}
