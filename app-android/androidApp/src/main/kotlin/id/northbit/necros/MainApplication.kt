package id.northbit.necros

import android.app.Application
import id.northbit.necros.core.data.dataModule
import id.northbit.necros.shared.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        startKoin { 
            androidContext(this@MainApplication)
            modules(
                androidAppModule,
                sharedModule,
                dataModule()
            )
        }
    }
}