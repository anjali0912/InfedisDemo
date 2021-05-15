package com.example.infedisdemo

import androidx.multidex.MultiDexApplication
import com.example.infedisdemo.di.remoteModules
import com.example.infedisdemo.di.repositoryModules
import com.example.infedisdemo.di.viewModelModules
import org.koin.android.ext.android.startKoin

class AppApplication  : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // Configure the koin dependency injection.
        startKoin(
            this, listOf(
                remoteModules,
                repositoryModules,
                viewModelModules
            )
        )
    }
}