package skdevicehub.smartphones.pockettechcart.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Smartphone
import androidx.compose.ui.graphics.vector.ImageVector

data class Benefit(
    val icon: ImageVector,
    val text: String,
)

val productBenefits = listOf<Benefit>(
    Benefit(
        icon = Icons.Filled.CheckCircle,
        text = "Tested quality",
    ),
    Benefit(
        icon = Icons.Filled.Security,
        text = "12-month warranty",
    ),
    Benefit(
        icon = Icons.Filled.Smartphone,
        text = "Everyday essential",
    ),
)
