package hu.norbertgal.cryptotracker.ui.cryptos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import hu.norbertgal.cryptotracker.CryptoTrackerApplication
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.model.CryptoListResult
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.ui.cryptos.adapter.CryptoAdapter
import javax.inject.Inject

class CryptoListActivity : AppCompatActivity(), CryptoListScreen {

    lateinit var cryptoAdapter: CryptoAdapter
    @Inject lateinit var cryptoListPresenter: CryptoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cryptolist)

        (application as CryptoTrackerApplication).injector.inject(this)
    }

    override fun showCryptos(cryptoList: List<CryptoPreview>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onStart() {
        super.onStart()
        cryptoListPresenter.attachScreen(this)
    }

    override fun onStop() {
        cryptoListPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
        //TODO("Not yet implemented")
    }

    private fun initRecyclerView() {
        cryptoAdapter = CryptoAdapter(this)
        findViewById<RecyclerView>(R.id.listCryptos).adapter = cryptoAdapter
    }
}