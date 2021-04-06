package hu.norbertgal.cryptotracker.model

data class Crypto(
        var id: Long?,
        val coinMarketCapId: Long,
        val name: String,
        val symbol: String,
        val price: Int,
        val max_supply: Int,
        val total_supply: Int,
        val market_rank: Int,
        val historicalData: HistoricalData
)