package hu.norbertgal.cryptotracker.ui.cryptos

import hu.norbertgal.cryptotracker.model.CryptoPreview

interface CryptoListScreen {
    fun showCryptos(cryptoList: List<CryptoPreview>?)
    fun showError(message: String)
}