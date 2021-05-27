package com.thorin.ngemovieeuy

import android.app.Application
import com.thorin.core.di.databaseModule
import com.thorin.core.di.networkModule
import com.thorin.core.di.repositoryModule
import com.thorin.ngemovieeuy.di.useCaseModule
import com.thorin.ngemovieeuy.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}