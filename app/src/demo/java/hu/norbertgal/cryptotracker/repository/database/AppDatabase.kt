package hu.norbertgal.cryptotracker.repository.database

import android.content.Context
import androidx.room.*
import hu.norbertgal.cryptotracker.model.Crypto
import hu.norbertgal.cryptotracker.model.CryptoPreview
import hu.norbertgal.cryptotracker.model.converter.MapConverter

@Database(entities = [CryptoPreview::class, Crypto::class], version = 1)
@TypeConverters(MapConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDAO
    abstract fun cryptoPreviewDao(): CryptoPreviewDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext,
                    AppDatabase::class.java)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }

}