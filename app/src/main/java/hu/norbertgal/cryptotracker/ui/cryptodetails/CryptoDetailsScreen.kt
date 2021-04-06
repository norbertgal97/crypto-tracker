package hu.norbertgal.cryptotracker.ui.cryptodetails

import hu.norbertgal.cryptotracker.model.CryptoListResult

interface CryptoDetailsScreen {
    fun showCryptoDetails(cryptoListData: CryptoListResult)
    fun showError(message: String)
}