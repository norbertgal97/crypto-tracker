package hu.norbertgal.cryptotracker.repository.network

import hu.norbertgal.cryptotracker.model.CryptoDataResult
import hu.norbertgal.cryptotracker.model.CryptoListResult
import retrofit2.Call

interface CryptoAPI {
    fun getCryptoList(): Call<CryptoListResult>
    fun getCryptoDetailsById(cryptoId: Long): Call<CryptoDataResult>
}