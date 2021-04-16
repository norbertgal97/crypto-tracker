package hu.norbertgal.cryptotracker.mock

import dagger.Module
import dagger.Provides
import hu.norbertgal.cryptotracker.repository.network.CryptoApi
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }

    @Provides
    @Singleton
    fun provideCryptoApi(client: OkHttpClient): CryptoApi = MockCryptoApi()
}