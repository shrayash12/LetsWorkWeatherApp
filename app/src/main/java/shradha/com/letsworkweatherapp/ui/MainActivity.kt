package shradha.com.letsworkweatherapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import shradha.com.letsworkweatherapp.R
import shradha.com.letsworkweatherapp.data.WeatherRepositoryImpl
import shradha.com.letsworkweatherapp.domain.WeatherViewModel
import shradha.com.letsworkweatherapp.domain.WeatherViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherRepository = WeatherRepositoryImpl(this)

        val weatherViewModel: WeatherViewModel by viewModels {
            WeatherViewModelFactory(weatherRepository)
        }

        weatherViewModel.citiesData.observe(this, Observer {
            Log.d(MainActivity::class.java.simpleName, "Data size :" + it.size)
        })

        weatherViewModel.errorCitiesData.observe(this, Observer {
            Log.d(MainActivity::class.java.simpleName, "Error message :$it")
        })
    }
}