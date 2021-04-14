package hu.norbertgal.cryptotracker.interactor.crypto.event

import hu.norbertgal.cryptotracker.model.Crypto

class GetCryptoDetailsEvent(
    var code: Int = 0,
    var crypto: Crypto? = null,
    var throwable: Throwable? = null
)