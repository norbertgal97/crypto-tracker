package hu.norbertgal.cryptotracker.interactor.crypto

import android.util.Log
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptoDetailsEvent
import hu.norbertgal.cryptotracker.interactor.crypto.event.GetCryptosEvent
import hu.norbertgal.cryptotracker.repository.network.NetworkConfig
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import org.greenrobot.eventbus.EventBus
import java.lang.Exception
import javax.inject.Inject

class CryptoInteractor @Inject constructor(private var cryptoApi: CryptoApi) {

    fun getCryptos(limit: Long) {
        val event = GetCryptosEvent()

        try {
            val cryptoQueryCall = cryptoApi.map(NetworkConfig.API_KEY, limit)

            val response = cryptoQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200. Result code is: " + response.code().toString())
            }

            event.code = response.code()
            event.cryptos = response.body()?.data
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getCryptoDetails(id: Long) {
        val event = GetCryptoDetailsEvent()

        try {
            val cryptoDetailsQueryCall = cryptoApi.latest(NetworkConfig.API_KEY, id)

            val response = cryptoDetailsQueryCall.execute()
            Log.d("Response", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200. Result code is: " + response.code().toString())
            }

            event.code = response.code()
            event.crypto = response.body()?.data?.get(id.toString())
            EventBus.getDefault().post(event)

        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }

    }

}