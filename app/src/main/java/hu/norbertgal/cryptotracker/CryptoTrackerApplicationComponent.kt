package hu.norbertgal.cryptotracker

import dagger.Component
import hu.norbertgal.cryptotracker.interactor.InteractorModule
import hu.norbertgal.cryptotracker.repository.network.NetworkModule
import hu.norbertgal.cryptotracker.ui.about.AboutFragment
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsFragment
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [PresenterModule::class, NetworkModule::class, InteractorModule::class])
interface CryptoTrackerApplicationComponent {
    fun inject(cryptoDetailsFragment: CryptoDetailsFragment)
    fun inject(aboutFragment: AboutFragment)
    fun inject(cryptoListFragment: CryptoListFragment)
}