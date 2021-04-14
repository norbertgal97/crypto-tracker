package hu.norbertgal.cryptotracker.ui.cryptodetails

import hu.norbertgal.cryptotracker.model.Crypto

interface CryptoDetailsScreen {
    fun showCryptoDetails(crypto: Crypto?)
    fun showError(message: String)
}