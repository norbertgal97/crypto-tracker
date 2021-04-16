package hu.norbertgal.cryptotracker

import android.app.Application
import hu.norbertgal.cryptotracker.interactor.InteractorModule
import hu.norbertgal.cryptotracker.repository.network.NetworkModule

class CryptoTrackerApplication: Application() {
    lateinit var injector: CryptoTrackerApplicationComponent

    override fun onCreate() {
        super.onCreate()

        injector = DaggerCryptoTrackerApplicationComponent.builder()
            .presenterModule(PresenterModule())
            .interactorModule(InteractorModule(this))
            .networkModule(NetworkModule())
            .build()
    }

}