package hu.norbertgal.cryptotracker

import dagger.Component
import hu.norbertgal.cryptotracker.interactor.InteractorModule
import hu.norbertgal.cryptotracker.mock.MockNetworkModule
import hu.norbertgal.cryptotracker.test.CryptoListTest
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : CryptoTrackerApplicationComponent {
    fun inject(cryptoListTest: CryptoListTest)
}