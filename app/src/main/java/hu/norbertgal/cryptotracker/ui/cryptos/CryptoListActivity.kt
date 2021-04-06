package hu.norbertgal.cryptotracker.ui.cryptos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.model.CryptoListResult
import hu.norbertgal.cryptotracker.model.CryptoPreview

class CryptoListActivity : AppCompatActivity(), CryptoListScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptolist)
    }

    override fun showCryptos(cryptoList: List<CryptoPreview>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        TODO("Not yet implemented")
    }

    override fun onStop() {
        super.onStop()
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        TODO("Not yet implemented")
    }
}