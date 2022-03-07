package shradha.com.letsworkweatherapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import shradha.com.letsworkweatherapp.R
import shradha.com.letsworkweatherapp.data.WeatherRepositoryImpl
import shradha.com.letsworkweatherapp.domain.WeatherViewModel
import shradha.com.letsworkweatherapp.domain.WeatherViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var weatherListAdapter: WeatherListAdapter
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerviewSetUp()

        weatherViewModel = createViewModel()
        weatherViewModel.citiesData.observe(this, Observer {
            weatherListAdapter.submitList(it)
        })

        weatherViewModel.errorCitiesData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun createViewModel(): WeatherViewModel {
        val weatherRepository = WeatherRepositoryImpl(this)
        val weatherViewModel: WeatherViewModel by viewModels {
            WeatherViewModelFactory(weatherRepository)
        }
        return weatherViewModel
    }

    private fun recyclerviewSetUp() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        weatherListAdapter = WeatherListAdapter()
        recyclerView.adapter = weatherListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}