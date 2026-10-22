package skdevicehub.smartphones.pockettechcart.di

import androidx.room.Room
import skdevicehub.smartphones.pockettechcart.data.database.UOWJDAppDatabase
import org.koin.dsl.module

private const val DB_NAME = "uowjd_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = UOWJDAppDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<UOWJDAppDatabase>().cartItemDao() }

    single { get<UOWJDAppDatabase>().orderDao() }
}