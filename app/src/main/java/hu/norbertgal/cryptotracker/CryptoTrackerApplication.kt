package hu.norbertgal.cryptotracker

import android.app.Application

class CryptoTrackerApplication: Application() {
    lateinit var injector: CryptoTrackerApplicationComponent

    override fun onCreate() {
        super.onCreate()

        injector = DaggerCryptoTrackerApplicationComponent.builder().presenterModule(PresenterModule()).build()

    }

}