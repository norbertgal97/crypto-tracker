package hu.norbertgal.cryptotracker.repository.network

import hu.norbertgal.cryptotracker.model.CryptoDataResult
import hu.norbertgal.cryptotracker.model.CryptoListResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CryptoApi {
    /**
     * Returns the latest market quote for 1 or more cryptocurrencies.
     * Returns the latest market quote for 1 or more cryptocurrencies.
     * @param id ID of cryptocurrency to return (required)
     * @return Call<CryptoListResult>
     */
    @GET("quotes/latest")
    fun latest(@Header("X-CMC_PRO_API_KEY") authorization: String, @Query("id") id: Long): Call<CryptoDataResult>

    /**
     * Returns a mapping of all cryptocurrencies to unique CoinMarketCap ids.
     * Each cryptocurrency returned includes typical identifiers such as name, symbol, and token_address for flexible mapping to id.
     * @param limit Specify the number of results to return. (required)
     * @return Call<CryptoListResult>
     */
    @GET("map")
    fun map(@Header("X-CMC_PRO_API_KEY") authorization: String, @Query("limit") limit: Long): Call<CryptoListResult>
}