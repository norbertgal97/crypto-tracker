package hu.norbertgal.cryptotracker.ui.cryptodetails

import hu.norbertgal.cryptotracker.model.CryptoDataResult

interface CryptoDetailsScreen {
    fun showCryptoDetails(cryptoData: CryptoDataResult)
    fun showError(message: String)
}