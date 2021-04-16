package hu.norbertgal.cryptotracker.mock

import hu.norbertgal.cryptotracker.model.*
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockCryptoApi : CryptoApi{
    override fun latest(authorization: String, id: Long): Call<CryptoDataResult> {
        //TODO("Not yet implemented")

        return object : Call<CryptoDataResult> {
            override fun clone(): Call<CryptoDataResult> {
                return this
            }

            override fun execute(): Response<CryptoDataResult> {
                return Response.success(null)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request? {
                return null
            }


            override fun enqueue(callback: Callback<CryptoDataResult>) {

            }

            override fun cancel() {

            }

            override fun timeout(): Timeout? {
                return null
            }
        }
    }

    override fun map(authorization: String, limit: Long): Call<CryptoListResult> {
        val cryptoPreviewList = ArrayList<CryptoPreview>()
        cryptoPreviewList.add(CryptoPreview(1, "Bitcoin", "BTC"))
        cryptoPreviewList.add(CryptoPreview(2, "Ethereum", "ETH"))

        val status = Status("2021-02-02", 0, "", 1000L, 1)

        val cryptoListResult = CryptoListResult(cryptoPreviewList, status)

        return object : Call<CryptoListResult> {
            override fun clone(): Call<CryptoListResult> {
                return this
            }

            override fun execute(): Response<CryptoListResult> {
                return Response.success(cryptoListResult)
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request? {
                return null
            }


            override fun enqueue(callback: Callback<CryptoListResult>) {

            }

            override fun cancel() {

            }

            override fun timeout(): Timeout? {
                return null
            }
        }
    }

    override fun update(authorization: String, body: Crypto): Call<CryptoDataResult> {
        TODO("Not yet implemented")
    }

    override fun delete(authorization: String, cryptoId: Long): Call<CryptoDataResult> {
        TODO("Not yet implemented")
    }

    override fun add(authorization: String, body: Crypto): Call<CryptoDataResult> {
        TODO("Not yet implemented")
    }
}