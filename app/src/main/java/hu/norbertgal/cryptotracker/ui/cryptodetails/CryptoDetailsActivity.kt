package hu.norbertgal.cryptotracker.ui.cryptodetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.norbertgal.cryptotracker.CryptoTrackerApplication
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.model.CryptoDataResult
import javax.inject.Inject

class CryptoDetailsActivity : AppCompatActivity(), CryptoDetailsScreen {

    @Inject lateinit var cryptoDetailsPresenter: CryptoDetailsPresenter

    override fun showCryptoDetails(crypto: Crypto?) {
        //TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        //TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as CryptoTrackerApplication).injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        cryptoDetailsPresenter.attachScreen(this)
        cryptoDetailsPresenter.refreshCryptoDetails(1)
    }

    override fun onStop() {
        cryptoDetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        //TODO("Not yet implemented")
    }

}