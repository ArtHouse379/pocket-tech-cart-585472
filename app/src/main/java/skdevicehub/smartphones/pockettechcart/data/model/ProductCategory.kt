package skdevicehub.smartphones.pockettechcart.data.model

import androidx.annotation.StringRes
import skdevicehub.smartphones.pockettechcart.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    SMARTPHONES(R.string.product_category_smartphones_title),
    FOLDABLE_PHONES(R.string.product_category_foldable_phones_title),
    CLASSIC_PHONES(R.string.product_category_classic_phones_title),
    ACCESSORIES(R.string.product_category_accessories_title),
}
