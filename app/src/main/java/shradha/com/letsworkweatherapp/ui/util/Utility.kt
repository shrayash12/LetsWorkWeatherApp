package shradha.com.letsworkweatherapp.ui.util

import android.content.res.Resources
import shradha.com.letsworkweatherapp.R
import shradha.com.letsworkweatherapp.data.model.City

const val SUNNY = "Sunny"
const val DRIZZLE = "Drizzle"
const val CLOUDY = "Cloudy"
const val OVERCAST = "Overcast"
const val STORMS = "Storms"


object Utility {
    fun getWeatherJsonInputStream(city: City, resources: Resources): Int {
        return when {
            city.shortDescription.contains(SUNNY) -> {
                R.raw.sunny
            }
            city.shortDescription.contains(DRIZZLE) -> {
                R.raw.moderate_raining
            }
            city.shortDescription.contains(CLOUDY) -> {
                R.raw.cloudy
            }
            city.shortDescription.contains(STORMS) -> {
                R.raw.weather_storm
            }
            city.shortDescription.contains(OVERCAST) -> {
                R.raw.brokenclouds
            }
            else -> {
                R.raw.default_weather
            }
        }
    }
    fun getCelsiusFromKelvin(temp: Double): String? {
        val ans = String.format("%.0f", temp)
        return ans + "\u2103"
    }

}
