package shradha.com.letsworkweatherapp.data

import android.content.Context
import com.google.gson.Gson
import shradha.com.letsworkweatherapp.data.local.LocalDataSource
import shradha.com.letsworkweatherapp.data.model.City
import shradha.com.letsworkweatherapp.data.model.WeatherResponse
import java.lang.Exception

interface WeatherRepository {
    fun getCities(): Result<List<City>>
}

class WeatherRepositoryImpl(
    private val context: Context
) : WeatherRepository {
    override fun getCities(): Result<List<City>> {
        val weatherJsonString = LocalDataSource.jsonDataFromAsset(context = context)
        weatherJsonString?.run {
            val data = Gson().fromJson(
                weatherJsonString,
                WeatherResponse::class.java
            )
            return Result.Success(data.cities)
        }
        return Result.Error(Exception("Json parsing failed"))

    }
}