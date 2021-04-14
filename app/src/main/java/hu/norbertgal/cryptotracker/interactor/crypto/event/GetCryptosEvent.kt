package hu.norbertgal.cryptotracker.interactor.crypto.event

import hu.norbertgal.cryptotracker.model.CryptoPreview

class GetCryptosEvent(
    var code: Int = 0,
    var cryptos: List<CryptoPreview>? = null,
    var throwable: Throwable? = null
)

