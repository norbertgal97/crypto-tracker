package hu.norbertgal.cryptotracker.repository.database

import hu.norbertgal.cryptotracker.model.Crypto

interface CryptoDAO {
    fun getAllCryptos(): List<Crypto>
    fun insertCrypto(crypto: Crypto): Long
    fun deleteCrypto(crypto: Crypto)
    fun updateCrypto(crypto: Crypto)
}