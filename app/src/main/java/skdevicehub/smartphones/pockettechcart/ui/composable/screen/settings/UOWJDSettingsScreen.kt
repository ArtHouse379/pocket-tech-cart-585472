package skdevicehub.smartphones.pockettechcart.ui.composable.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import skdevicehub.smartphones.pockettechcart.R
import skdevicehub.smartphones.pockettechcart.ui.composable.approot.LocalContentBottomPadding
import skdevicehub.smartphones.pockettechcart.ui.composable.screen.settings.card.AppInfoCard
import skdevicehub.smartphones.pockettechcart.ui.theme.LocalDimens

@Composable
fun UOWJDSettingsScreen(modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current
    val supportLink = stringResource(R.string.uowjd_customer_support_link)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimens.screenPadding)
            .padding(bottom = LocalContentBottomPadding.current),
    ) {
        AppInfoCard()

        if (supportLink.isNotBlank()) {
            Spacer(modifier = Modifier.height(dimens.contentSpacing))

            CustomerSupportCard()
        }
    }
}
