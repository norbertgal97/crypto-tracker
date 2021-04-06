package hu.norbertgal.cryptotracker.model

data class HistoricalData(
        var id: Long?,
        val percentChange1H: Double,
        val percentChange24H: Double,
        val percentChange7D: Double,
        val percentChange30D: Double
)