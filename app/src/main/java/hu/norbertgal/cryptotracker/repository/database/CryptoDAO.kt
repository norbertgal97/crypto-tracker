package hu.norbertgal.cryptotracker.repository.database

import androidx.room.*
import hu.norbertgal.cryptotracker.model.Crypto

@Dao
interface CryptoDAO {
    @Query("SELECT * FROM cryptodetails WHERE coinmarketcapid = :id")
    fun getCryptoById(id: Long) : Crypto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCrypto(crypto: Crypto): Long

    @Delete
    fun deleteCrypto(crypto: Crypto)

    @Update
    fun updateCrypto(crypto: Crypto)
}