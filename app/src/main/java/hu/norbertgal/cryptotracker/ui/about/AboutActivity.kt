package hu.norbertgal.cryptotracker.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.norbertgal.cryptotracker.CryptoTrackerApplication
import hu.norbertgal.cryptotracker.model.About
import javax.inject.Inject

class AboutActivity : AppCompatActivity(), AboutScreen {

    @Inject lateinit var aboutPresenter: AboutPresenter

    override fun showAbout(about: About) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as CryptoTrackerApplication).injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        aboutPresenter.attachScreen(this)
    }

    override fun onStop() {
        aboutPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        //TODO("Not yet implemented")
    }

}