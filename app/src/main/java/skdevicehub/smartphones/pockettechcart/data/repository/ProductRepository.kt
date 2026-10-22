package skdevicehub.smartphones.pockettechcart.data.repository

import skdevicehub.smartphones.pockettechcart.data.model.Product
import skdevicehub.smartphones.pockettechcart.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "5G Smartphone",
            description = "A capable 5G smartphone for fast browsing, streaming, and daily communication. Its bright touchscreen keeps apps and media easy to view. A multi-lens camera handles everyday photos and video calls. Ample storage leaves room for apps, pictures, and downloads.",
            category = ProductCategory.SMARTPHONES,
            price = 449.99,
            imageUrl = "https://images.pexels.com/photos/33693580/pexels-photo-33693580/free-photo-of-modern-smartphone-on-textured-surface.jpeg",
        ),
        Product(
            id = 2,
            title = "Camera Smartphone",
            description = "This camera-focused smartphone makes it simple to capture sharp everyday moments. The responsive display is well suited to reviewing photos and editing clips. Reliable performance keeps social apps, navigation, and messaging moving smoothly. Its balanced design is comfortable for regular use.",
            category = ProductCategory.SMARTPHONES,
            price = 599.99,
            imageUrl = "https://images.pexels.com/photos/20360335/pexels-photo-20360335/free-photo-of-product-shot-of-a-modern-smartphone.jpeg",
        ),
        Product(
            id = 3,
            title = "Budget Smartphone",
            description = "A practical smartphone that covers calls, messages, photos, and popular apps without a premium price. The large screen offers plenty of room for video and web browsing. All-day battery life supports commuting, work, and casual use. It includes the essential accessories needed to get started.",
            category = ProductCategory.SMARTPHONES,
            price = 219.99,
            imageUrl = "https://images.pexels.com/photos/30165508/pexels-photo-30165508/free-photo-of-modern-smartphone-unboxing-with-accessories.jpeg",
        ),
        Product(
            id = 4,
            title = "Foldable Smartphone",
            description = "A foldable smartphone that opens into a spacious screen for reading, viewing, and multitasking. The flexible display gives apps extra working room while the device remains pocketable when closed. Its hinge is designed for frequent daily folding. Multiple cameras cover snapshots, video calls, and hands-free framing.",
            category = ProductCategory.FOLDABLE_PHONES,
            price = 1299.99,
            imageUrl = "https://images.pexels.com/photos/4313857/pexels-photo-4313857.jpeg",
        ),
        Product(
            id = 5,
            title = "Flip Smartphone",
            description = "This flip smartphone folds down neatly for pockets and small bags. Open it to reveal a full touchscreen for apps, messages, and photos. The outer display lets you check useful information without unfolding the phone. Flex mode also supports steady selfies and tabletop video calls.",
            category = ProductCategory.FOLDABLE_PHONES,
            price = 849.99,
            imageUrl = "https://images.pexels.com/photos/4716356/pexels-photo-4716356.jpeg",
        ),
        Product(
            id = 6,
            title = "Compact Foldable",
            description = "A compact foldable phone that combines a modern touchscreen with a space-saving design. The glossy body closes securely for easier carrying. Its vivid display is suited to browsing, entertainment, and everyday tasks. A flexible hinge offers useful angles for photos and video chats.",
            category = ProductCategory.FOLDABLE_PHONES,
            price = 749.99,
            imageUrl = "https://images.pexels.com/photos/32136396/pexels-photo-32136396/free-photo-of-sleek-modern-smartphone-with-foldable-design.jpeg",
        ),
        Product(
            id = 7,
            title = "Keypad Phone",
            description = "A straightforward keypad phone for dependable calls and text messages. Physical buttons make numbers and menus easy to operate by touch. The simple display and focused features help the battery last longer between charges. It is a practical spare or first phone.",
            category = ProductCategory.CLASSIC_PHONES,
            price = 34.99,
            imageUrl = "https://images.pexels.com/photos/28266695/pexels-photo-28266695/free-photo-of-vintage-cell-phone.jpeg",
        ),
        Product(
            id = 8,
            title = "Classic Flip Phone",
            description = "This classic flip phone keeps calling and texting simple in a familiar folding design. Opening the handset answers calls naturally, while closing it protects the keys. Large controls support comfortable number entry and menu navigation. Long standby time makes it useful for travel or emergencies.",
            category = ProductCategory.CLASSIC_PHONES,
            price = 49.99,
            imageUrl = "https://images.pexels.com/photos/14127221/pexels-photo-14127221.jpeg",
        ),
        Product(
            id = 9,
            title = "Retro Mobile Phone",
            description = "A restored retro mobile phone for collectors and fans of classic handset design. Its tactile keypad and compact screen recreate a simpler calling experience. The sturdy shell is made for basic everyday handling. It is supplied as a physical collectible with functional controls.",
            category = ProductCategory.CLASSIC_PHONES,
            price = 79.99,
            imageUrl = "https://images.pexels.com/photos/8680075/pexels-photo-8680075.jpeg",
        ),
        Product(
            id = 10,
            title = "Wireless Charger",
            description = "A wireless charging pad that powers compatible phones without repeatedly plugging in a cable. Its flat surface fits neatly on a desk or bedside table. A non-slip finish helps keep the handset aligned while charging. Use it with a suitable USB power adapter for convenient daily top-ups.",
            category = ProductCategory.ACCESSORIES,
            price = 24.99,
            imageUrl = "https://images.pexels.com/photos/15921116/pexels-photo-15921116/free-photo-of-top-view-of-an-iphone-lying-on-an-inductive-charger.jpeg",
        ),
        Product(
            id = 11,
            title = "Phone Case",
            description = "A protective phone case that helps shield a handset from scratches and everyday knocks. Raised edges add protection around the screen and camera area. The slim profile keeps buttons and charging ports easy to reach. Its grippy finish also makes the phone more secure in hand.",
            category = ProductCategory.ACCESSORIES,
            price = 14.99,
            imageUrl = "https://images.pexels.com/photos/5592309/pexels-photo-5592309.jpeg",
        ),
        Product(
            id = 12,
            title = "Power Bank",
            description = "A portable power bank for charging a phone when a wall socket is out of reach. Its capacity provides useful backup power for commutes, travel, and long days. USB charging works with a wide range of phone cables. The compact body slips easily into a backpack or work bag.",
            category = ProductCategory.ACCESSORIES,
            price = 29.99,
            imageUrl = "https://images.pexels.com/photos/37475677/pexels-photo-37475677/free-photo-of-smartphone-charging-with-portable-power-bank.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
