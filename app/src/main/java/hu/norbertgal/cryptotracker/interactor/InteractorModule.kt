package hu.norbertgal.cryptotracker.interactor

import android.content.Context
import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import javax.inject.Singleton

@Module
class InteractorModule (private val context: Context){
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun provideCryptoInteractor(cryptoApi: CryptoApi, context: Context) = CryptoInteractor(cryptoApi, context)
}