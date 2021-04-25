package hu.norbertgal.cryptotracker.interactor.crypto

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptoDetailsEvent
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptosEvent
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.repository.database.AppDatabase
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import hu.norbertgal.cryptotracker.repository.network.NetworkConfig
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject


class CryptoInteractor @Inject constructor(
        private var cryptoApi: CryptoApi,
        private val context: Context
) {

    //Preview
    fun getCryptoPreviews(limit: Long) {
        val event = GetCryptosEvent()

        if (!isInternetAvailable()) {
            loadCryptoPreviewsFromDatabase(event)
            return
        }

        try {
            val cryptoQueryCall = cryptoApi.map(NetworkConfig.API_KEY, limit)

            val response = cryptoQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200. Result code is: " + response.code().toString())
            }

            response.body()?.data?.let { createCryptoPreviews(it) }

            event.code = response.code()
            event.cryptos = response.body()?.data
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    private fun createCryptoPreviews(cryptoPreviews: List<CryptoPreview>) {
        Thread {
            AppDatabase.getInstance(context).cryptoPreviewDao().insertAllCryptoPreviews(cryptoPreviews)
        }.start()
    }

    //Details
    fun getCryptoDetails(id: Long) {
        val event = GetCryptoDetailsEvent()

        if (!isInternetAvailable()) {
            loadCryptoDetailsFromDatabase(event, id)
            return
        }

        try {
            val cryptoDetailsQueryCall = cryptoApi.latest(NetworkConfig.API_KEY, id)

            val response = cryptoDetailsQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200. Result code is: " + response.code().toString())
            }

            response.body()?.data?.get(id.toString())?.let { createCryptoDetails(it) }

            event.code = response.code()
            event.crypto = response.body()?.data?.get(id.toString())
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

    private fun createCryptoDetails(crypto: Crypto) {
        Thread {
            AppDatabase.getInstance(context).cryptoDao().insertCrypto(crypto)
        }.start()
    }

    fun deleteCryptoDetails(crypto: Crypto) {
        Thread {
            AppDatabase.getInstance(context).cryptoDao().deleteCrypto(crypto)
        }.start()
    }

    fun updateCryptoDetails(crypto: Crypto) {
        Thread {
            AppDatabase.getInstance(context).cryptoDao().updateCrypto(crypto)
        }.start()
    }

    /**
     * The connectivityManager.activeNetworkInfo is deprecated in API level 30
     * The connectivityManager.activeNetwork requires API level 23 (current min is 22), so I used the deprecated activeNetworkInfo
     */
    private fun isInternetAvailable(): Boolean {
        var result = false
        val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.run {
            connectivityManager.activeNetworkInfo?.run {
                result = when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }

        return result
    }

    private fun loadCryptoPreviewsFromDatabase(event: GetCryptosEvent) {
        Thread {
            val cryptoPreviews =
                    AppDatabase.getInstance(context).cryptoPreviewDao().getAllCryptoPreviews()
            event.cryptos = cryptoPreviews
            EventBus.getDefault().post(event)
        }.start()
    }

    private fun loadCryptoDetailsFromDatabase(event: GetCryptoDetailsEvent, id: Long) {
        Thread {
            val cryptoPreviews: Crypto? =
                    AppDatabase.getInstance(context).cryptoDao().getCryptoById(id)
            event.crypto = cryptoPreviews
            EventBus.getDefault().post(event)
        }.start()
    }

}