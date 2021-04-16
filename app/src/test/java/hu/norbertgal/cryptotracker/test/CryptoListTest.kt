package hu.norbertgal.cryptotracker.test

import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.testInjector
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListPresenter
import hu.norbertgal.cryptotracker.ui.cryptos.CryptoListScreen
import hu.norbertgal.cryptotracker.utils.argumentCaptor
import hu.norbertgal.cryptotracker.utils.mock
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
class CryptoListTest {

    @Inject
    lateinit var cryptoListPresenter: CryptoListPresenter
    private lateinit var cryptoListScreen: CryptoListScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        cryptoListScreen = mock()
        cryptoListPresenter.attachScreen(cryptoListScreen)
    }

    @Test
    fun testCryptoListSize() {
        cryptoListPresenter.refreshCryptos(2)

        val list = argumentCaptor<MutableList<CryptoPreview>>()
        verify(cryptoListScreen).showCryptos(list.capture())
        assert(list.value.size == 2)
    }

    @After
    fun tearDown() {
        cryptoListPresenter.detachScreen()
    }

}