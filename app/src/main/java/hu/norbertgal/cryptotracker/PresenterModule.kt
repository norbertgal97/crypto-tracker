package hu.norbertgal.cryptotracker

import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.ui.about.AboutPresenter
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsPresenter
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListPresenter
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun aboutPresenter() = AboutPresenter()

    @Provides
    @Singleton
    fun cryptoDetailsPresenter() = CryptoDetailsPresenter()

    @Provides
    @Singleton
    fun cryptoListPresenter() = CryptoListPresenter()
}