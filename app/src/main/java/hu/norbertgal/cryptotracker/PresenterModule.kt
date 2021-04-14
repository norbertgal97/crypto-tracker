package hu.norbertgal.cryptotracker

import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.ui.about.AboutPresenter
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsPresenter
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListPresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun aboutPresenter() = AboutPresenter()

    @Provides
    @Singleton
    fun cryptoDetailsPresenter(executor: Executor, cryptoInteractor: CryptoInteractor) = CryptoDetailsPresenter(executor, cryptoInteractor)

    @Provides
    @Singleton
    fun cryptoListPresenter(executor: Executor, cryptoInteractor: CryptoInteractor) = CryptoListPresenter(executor, cryptoInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}