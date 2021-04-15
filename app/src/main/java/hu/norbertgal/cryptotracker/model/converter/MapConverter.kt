package hu.norbertgal.cryptotracker.model.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hu.norbertgal.cryptotracker.model.Quote

object MapConverter {

    @JvmStatic
    @TypeConverter
    fun fromString(value: String): Map<String, Quote> {
        val mapType = object : TypeToken<Map<String, Quote>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringMap(map: Map<String, Quote>): String {
        return Gson().toJson(map)
    }
}