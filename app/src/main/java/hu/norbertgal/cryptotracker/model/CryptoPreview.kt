package hu.norbertgal.cryptotracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cryptopreviews")
data class CryptoPreview(
        @SerializedName("id")
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id")
        val coinMarketCapId: Long,

        @ColumnInfo(name = "name")
        @SerializedName("name")
        val name: String,

        @ColumnInfo(name = "symbol")
        @SerializedName("symbol")
        val symbol: String
)