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
        val status = Status("2021-02-02", 0, "", 1000L, 1)

        val quote = Quote(55050.56, 0.593, 2.83, -0.96, -1.69)
        val quoteMap = HashMap<String, Quote>()
        quoteMap["USD"] = quote

        val crypto = Crypto(1, "Bitcoin", "BTC", 21000000.0, 18692706.0, 1, quoteMap)

        val data = HashMap<String, Crypto>()
        data["1"] = crypto

        val cryptoDataResult = CryptoDataResult(data, status)

        return object : Call<CryptoDataResult> {
            override fun clone(): Call<CryptoDataResult> {
                return this
            }

            override fun execute(): Response<CryptoDataResult> {
                return Response.success(cryptoDataResult)
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
        val cryptoMap = HashMap<String, Crypto>()
        val status = Status("2021-02-02", 0, "", 1000L, 1)
        val cryptoDataResult = CryptoDataResult(cryptoMap, status)

        return object : Call<CryptoDataResult> {
            override fun clone(): Call<CryptoDataResult> {
                return this
            }

            override fun execute(): Response<CryptoDataResult> {
                return Response.success(cryptoDataResult)
            }

            override fun enqueue(callback: Callback<CryptoDataResult>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout? {
                return null
            }

        }
    }

    override fun add(authorization: String, body: Crypto): Call<CryptoDataResult> {
        TODO("Not yet implemented")
    }
}