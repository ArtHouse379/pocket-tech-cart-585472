package skdevicehub.smartphones.pockettechcart

import android.app.Application
import skdevicehub.smartphones.pockettechcart.di.dataModule
import skdevicehub.smartphones.pockettechcart.di.dispatcherModule
import skdevicehub.smartphones.pockettechcart.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class UOWJDApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@UOWJDApplication)
            modules(appModules)
        }
    }
}
