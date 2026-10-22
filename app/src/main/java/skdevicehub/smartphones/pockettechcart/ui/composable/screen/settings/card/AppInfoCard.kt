package skdevicehub.smartphones.pockettechcart.ui.composable.screen.settings.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import skdevicehub.smartphones.pockettechcart.R
import skdevicehub.smartphones.pockettechcart.ui.theme.ControlDivider
import skdevicehub.smartphones.pockettechcart.ui.theme.LocalDimens
import skdevicehub.smartphones.pockettechcart.ui.theme.cardBorderStroke

@Composable
fun AppInfoCard(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val companyName = stringResource(R.string.uowjd_company_name)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimens.cardCornerRadius),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        border = cardBorderStroke(),
    ) {
        Column(modifier = Modifier.padding(dimens.cardPadding)) {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = stringResource(R.string.settings_screen_app_label),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.labelMedium,
            )

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            ControlDivider()

            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            if (companyName.isNotBlank()) {
                MetaRow(
                    label = stringResource(R.string.settings_screen_company_label),
                    value = companyName,
                )

                Spacer(modifier = Modifier.height(dimens.tightSpacing))
            }

            MetaRow(
                label = stringResource(R.string.settings_screen_version_label),
                value = stringResource(R.string.uowjd_app_version),
            )
        }
    }
}

@Composable
private fun MetaRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    valueColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(LocalDimens.current.contentSpacing),
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodySmall,
        )

        Text(
            text = value,
            modifier = Modifier.weight(1f),
            color = valueColor,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.End,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}
