package hu.norbertgal.cryptotracker

import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.interactor.crypto.CryptoInteractor
import hu.norbertgal.cryptotracker.ui.about.AboutPresenter
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsPresenter
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListPresenter
import hu.norbertgal.cryptotracker.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule() {
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
    fun networkExecutor(): Executor = UiExecutor()
}