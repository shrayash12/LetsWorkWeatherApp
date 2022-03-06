package shradha.com.letsworkweatherapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import shradha.com.letsworkweatherapp.data.Result
import shradha.com.letsworkweatherapp.data.WeatherRepository
import shradha.com.letsworkweatherapp.data.model.City

class WeatherViewModel(
    weatherRepository: WeatherRepository,
    dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _citiesData = MutableLiveData<List<City>>()
    val citiesData: LiveData<List<City>> = _citiesData

    private val _errorCitiesData = MutableLiveData<String>()
    val errorCitiesData: LiveData<String> = _errorCitiesData

    init {
        viewModelScope.launch(dispatcher) {
            val result = weatherRepository.getCities()
            when (result) {
                is Result.Success<List<City>> -> {
                    _citiesData.postValue(result.data)
                }
                else -> {
                    _errorCitiesData.postValue(result.toString())
                }
            }
        }
    }
}