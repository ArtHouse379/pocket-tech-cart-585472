package skdevicehub.smartphones.pockettechcart.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import skdevicehub.smartphones.pockettechcart.data.database.dao.CartItemDao
import skdevicehub.smartphones.pockettechcart.data.database.dao.OrderDao
import skdevicehub.smartphones.pockettechcart.data.database.converter.Converters
import skdevicehub.smartphones.pockettechcart.data.entity.CartItemEntity
import skdevicehub.smartphones.pockettechcart.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class UOWJDAppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}