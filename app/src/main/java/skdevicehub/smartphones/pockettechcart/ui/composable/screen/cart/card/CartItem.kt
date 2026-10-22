package skdevicehub.smartphones.pockettechcart.ui.composable.screen.cart.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import skdevicehub.smartphones.pockettechcart.R
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.shared.ProductImage
import skdevicehub.smartphones.pockettechcart.ui.state.CartItemUiState
import skdevicehub.smartphones.pockettechcart.ui.theme.ControlDivider
import skdevicehub.smartphones.pockettechcart.ui.theme.LocalDimens
import skdevicehub.smartphones.pockettechcart.ui.theme.imageBorder

private val ImageSize = 72.dp

@Composable
fun CartItem(
    item: CartItemUiState,
    modifier: Modifier = Modifier,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    val dimens = LocalDimens.current
    val imageShape = RoundedCornerShape(dimens.cornerRadius)

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimens.contentSpacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ProductImage(
                imageUrl = item.productImageUrl,
                modifier = Modifier
                    .size(ImageSize)
                    .clip(imageShape)
                    .imageBorder(imageShape),
            )

            Spacer(modifier = Modifier.width(dimens.contentSpacing))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.productTitle,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))

                Text(
                    text = stringResource(R.string.price, item.productPrice * item.quantity),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onMinusClick,
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = stringResource(
                                R.string.decrease_quantity_icon_description
                            ),
                        )
                    }

                    Text(
                        text = item.quantity.toString(),
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleSmall,
                    )

                    IconButton(
                        onClick = onPlusClick,
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        ),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(
                                R.string.increase_quantity_icon_description
                            ),
                        )
                    }
                }
            }

            IconButton(
                onClick = onDeleteClick,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.error,
                ),
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete_item_icon_description),
                )
            }
        }

        ControlDivider()
    }
}
