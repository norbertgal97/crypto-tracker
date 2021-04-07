package hu.norbertgal.cryptotracker

import dagger.Component
import hu.norbertgal.cryptotracker.ui.about.AboutActivity
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsActivity
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [PresenterModule::class])
interface CryptoTrackerApplicationComponent {
    fun inject(aboutActivity: AboutActivity)
    fun inject(cryptoDetailsActivity: CryptoDetailsActivity)
    fun inject(cryptoListActivity: CryptoListActivity)
}