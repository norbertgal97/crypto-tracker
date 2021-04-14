package hu.norbertgal.cryptotracker.interactor

import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideCryptoInteractor(cryptoApi: CryptoApi) = CryptoInteractor(cryptoApi)
}