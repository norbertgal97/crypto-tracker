package hu.norbertgal.cryptotracker.test

import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptoDetailsEvent
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.testInjector
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsPresenter
import hu.norbertgal.cryptotracker.ui.cryptodetails.CryptoDetailsScreen
import hu.norbertgal.cryptotracker.utils.mock
import hu.norbertgal.cryptotracker.utils.nullableArgumentCaptor
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.lang.Exception
import javax.inject.Inject

@Config(manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner::class)
class CryptoDetailsTest {

    @Inject
    lateinit var cryptoDetailsPresenter: CryptoDetailsPresenter
    private lateinit var cryptoDetailsScreen: CryptoDetailsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        cryptoDetailsScreen = mock()
        cryptoDetailsPresenter.attachScreen(cryptoDetailsScreen)
    }

    @Test
    fun testCryptoDetails() {
        cryptoDetailsPresenter.refreshCryptoDetails(1)

        val crypto = nullableArgumentCaptor<Crypto>()
        verify(cryptoDetailsScreen).showCryptoDetails(crypto.capture())

        assert(crypto.value?.coinMarketCapId == 1L)
        assert(crypto.value?.cmcRank == 1)
        assert(crypto.value?.maxSupply == 21000000.0)
        assert(crypto.value?.quote?.get("USD")?.price  == 55050.56)
    }

    @Test
    fun testQuoteSize() {
        cryptoDetailsPresenter.refreshCryptoDetails(1)

        val crypto = nullableArgumentCaptor<Crypto>()
        verify(cryptoDetailsScreen).showCryptoDetails(crypto.capture())

        assert(crypto.value?.quote?.size == 1)
    }

    @Test
    fun testShowError() {
        val event = GetCryptoDetailsEvent()
        event.code = 400
        event.throwable = Exception("Result code is not 200. Result code is: 400")

        cryptoDetailsPresenter.onEventMainThread(event)

        verify(cryptoDetailsScreen).showError("Result code is not 200. Result code is: 400")
    }


    @After
    fun tearDown() {
        cryptoDetailsPresenter.detachScreen()
    }
}