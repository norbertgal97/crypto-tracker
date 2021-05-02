package hu.norbertgal.cryptotracker.test

import hu.norbertgal.cryptotracker.model.About
import hu.norbertgal.cryptotracker.testInjector
import hu.norbertgal.cryptotracker.ui.about.AboutPresenter
import hu.norbertgal.cryptotracker.ui.about.AboutScreen
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
class AboutTest {

    @Inject
    lateinit var aboutPresenter: AboutPresenter
    private lateinit var aboutScreen: AboutScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        aboutScreen = mock()
        aboutPresenter.attachScreen(aboutScreen)
    }

    @Test
    fun testShowAbout() {
        aboutPresenter.getAbout()

        val about = About("Gál Norbert", "TK4XI3", "App version: v4.1.0")
        verify(aboutScreen).showAbout(about)
    }

    @After
    fun tearDown() {
        aboutPresenter.detachScreen()
    }
}