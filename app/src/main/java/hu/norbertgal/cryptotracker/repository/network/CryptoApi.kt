package hu.norbertgal.cryptotracker.repository.network

import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.model.CryptoDataResult
import hu.norbertgal.cryptotracker.model.CryptoListResult
import retrofit2.Call
import retrofit2.http.*

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

    /**
     * Update an existing crypto
     *
     * @param body Crypto object that needs to be added to the store (required)
     * @return Call<CryptoDataResult>
     */
    @PUT("update")
    fun update(@Header("X-CMC_PRO_API_KEY") authorization: String, @Body body: Crypto): Call<CryptoDataResult>

    /**
     * Deletes a cryptocurrency.
     * Deletes a cryptocurrency by ID.
     * @param cryptoId ID of the cryptocurrency that needs to be deleted (required)
     * @return Call<CryptoDataResult>
     */
    @DELETE("delete/{cryptoId}")
    fun delete(@Header("X-CMC_PRO_API_KEY") authorization: String, @Path("cryptoId") cryptoId: Long): Call<CryptoDataResult>

    /**
     * Add a new crypto to the database
     *
     * @param body Crypto object that needs to be added to the store (required)
     * @return Call<CryptoDataResult>
     */
    @POST("add")
    fun add(@Header("X-CMC_PRO_API_KEY") authorization: String, @Body body: Crypto): Call<CryptoDataResult>

}