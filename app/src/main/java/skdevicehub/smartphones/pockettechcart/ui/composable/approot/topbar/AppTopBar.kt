package skdevicehub.smartphones.pockettechcart.ui.composable.approot.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import skdevicehub.smartphones.pockettechcart.R
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.matchesAnyRoute
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.topbar.canNavigateBackRoutes
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.topbar.topBarTitleRes
import skdevicehub.smartphones.pockettechcart.ui.composable.navigation.NavRoute
import skdevicehub.smartphones.pockettechcart.ui.theme.LocalDimens
import skdevicehub.smartphones.pockettechcart.ui.theme.StatusBarIconsFor

private val IconSize = 32.dp

private const val DisabledAlpha = 0.38f

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentDestination: NavDestination?,
    isCartNotEmpty: Boolean,
    onClearCartIconClick: () -> Unit,
    onNavigateBack: () -> Unit,
) {
    val dimens = LocalDimens.current
    val isCartScreen = currentDestination?.hasRoute(route = NavRoute.Cart::class) == true
    val canNavigateBack = currentDestination.matchesAnyRoute(canNavigateBackRoutes)
    val containerColor = MaterialTheme.colorScheme.primary

    StatusBarIconsFor(containerColor)

    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(IconSize)
                        .clip(RoundedCornerShape(dimens.cornerRadius)),
                )

                Spacer(modifier = Modifier.width(dimens.itemSpacing))

                Text(
                    text = topBarTitleRes(currentDestination)?.let { stringResource(it) }.orEmpty(),
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },

        actions = {
            if (isCartScreen) {
                IconButton(
                    onClick = { onClearCartIconClick() },
                    enabled = isCartNotEmpty,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContentColor = MaterialTheme.colorScheme.onPrimary
                            .copy(alpha = DisabledAlpha),
                    ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(R.string.clear_cart_icon_description),
                        modifier = Modifier.size(22.dp),
                    )
                }
            }
        },

        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_icon_description),
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}
