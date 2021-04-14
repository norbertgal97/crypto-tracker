package hu.norbertgal.cryptotracker.model

import com.google.gson.annotations.SerializedName

data class CryptoPreview(
        @SerializedName("id")
        val coinMarketCapId: Long,
        @SerializedName("name")
        val name: String,
        @SerializedName("symbol")
        val symbol: String
)