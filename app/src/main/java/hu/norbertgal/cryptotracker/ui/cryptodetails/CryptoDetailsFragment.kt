package hu.norbertgal.cryptotracker.ui.cryptodetails

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.norbertgal.cryptotracker.R
import hu.norbertgal.cryptotracker.injector
import hu.norbertgal.cryptotracker.model.Crypto
import kotlinx.android.synthetic.main.fragment_crypto_details.*
import javax.inject.Inject

class CryptoDetailsFragment(val id: Long) : Fragment(), CryptoDetailsScreen {

    @Inject
    lateinit var cryptoDetailsPresenter: CryptoDetailsPresenter
    private var cryptoDetails: Crypto? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crypto_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDeleteButton()
        setUpUpdateButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("CryptoDetailsFragment", "onAttach")
        injector.inject(this)
        cryptoDetailsPresenter.attachScreen(this)
        cryptoDetailsPresenter.refreshCryptoDetails(id)
    }

    override fun onDetach() {
        Log.d("CryptoDetailsFragment", "onDetach")
        cryptoDetailsPresenter.detachScreen()
        super.onDetach()
    }

    override fun showCryptoDetails(crypto: Crypto?) {
        cryptoDetails = crypto

        if (crypto == null) {
            showEmptyDetails()
            return
        }

        tvName.text = crypto.name
        tvPrice.text = "$".plus(String.format("%.3f", crypto.quote["USD"]?.price))
        tvMaxSupply.text = "Max supply: ".plus(crypto.maxSupply.toLong())
        tvTotalSupply.text = "Total supply: ".plus(crypto.totalSupply.toLong())
        tvMarketRank.text = "Market rank: #".plus(crypto.cmcRank)
        tvPercentchange1h.text = String.format("%.3f", crypto.quote["USD"]?.percentChange1h).plus("%")
        tvPercentchange24h.text = String.format("%.3f", crypto.quote["USD"]?.percentChange24h).plus("%")
        tvPercentchange7d.text = String.format("%.3f", crypto.quote["USD"]?.percentChange7d).plus("%")
        tvPercentchange30d.text = String.format("%.3f", crypto.quote["USD"]?.percentChange30d).plus("%")
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showEmptyDetails() {
        tvName.text = "-"
        tvPrice.text = "$-"
        tvMaxSupply.text = "Max supply: -"
        tvTotalSupply.text = "Total supply: -"
        tvMarketRank.text = "Market rank: #-"
        tvPercentchange1h.text = "-"
        tvPercentchange24h.text = "-"
        tvPercentchange7d.text = "-"
        tvPercentchange30d.text = "-"
    }

    private fun setUpDeleteButton() {
        btnDelete.setOnClickListener {
            cryptoDetails?.let { crypto -> cryptoDetailsPresenter.deleteCryptoDetails(crypto) }
            showEmptyDetails()
        }
    }

    private fun setUpUpdateButton() {
        btnUpdate.setOnClickListener {
            cryptoDetails?.quote?.get("USD")?.price  = etPrice.text.toString().toDouble()
            cryptoDetails?.let { crypto -> cryptoDetailsPresenter.updateCryptoDetails(crypto)}
            tvPrice.text = "$".plus(etPrice.text)
        }
    }
}