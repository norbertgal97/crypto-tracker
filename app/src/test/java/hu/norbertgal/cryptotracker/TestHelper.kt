package hu.norbertgal.cryptotracker

import androidx.test.core.app.ApplicationProvider
import hu.norbertgal.cryptotracker.interactor.InteractorModule
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = ApplicationProvider.getApplicationContext<CryptoTrackerApplication>()
        val component = DaggerTestComponent.builder().testModule(TestModule()).interactorModule(InteractorModule(application)).build()
        application.injector = component
        return component
    }