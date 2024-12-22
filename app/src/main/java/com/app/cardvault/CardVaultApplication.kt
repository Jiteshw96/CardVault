package com.app.cardvault

import android.app.Application
import com.app.data.di.dataModule
import com.app.presentation.di.viewModelModule
import com.app.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin




class CardVaultApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CardVaultApplication)
            modules(
                viewModelModule,
                dataModule,
                remoteModule
            )
        }
    }
}