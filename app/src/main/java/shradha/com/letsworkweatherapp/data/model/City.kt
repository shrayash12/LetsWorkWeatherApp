package shradha.com.letsworkweatherapp.data.model

data class City(
    val name: String,
    val country: String,
    val lat: Double,
    val long: Double,
    val temp: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val shortDescription: String
)

