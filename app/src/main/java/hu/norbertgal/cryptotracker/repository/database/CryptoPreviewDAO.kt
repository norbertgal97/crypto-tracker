package hu.norbertgal.cryptotracker.repository.database

import androidx.room.*
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.model.CryptoPreview

@Dao
interface CryptoPreviewDAO {
    @Query("SELECT * FROM cryptopreviews")
    fun getAllCryptoPreviews(): List<CryptoPreview>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCryptoPreviews(cryptoPreviews : List<CryptoPreview>)
}