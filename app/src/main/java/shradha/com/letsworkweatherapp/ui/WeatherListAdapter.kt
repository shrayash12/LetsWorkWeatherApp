package shradha.com.letsworkweatherapp.ui

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import shradha.com.letsworkweatherapp.R
import shradha.com.letsworkweatherapp.data.model.City
import shradha.com.letsworkweatherapp.ui.util.Utility

class WeatherListAdapter : ListAdapter<City, WeatherListAdapter.MyViewHolder>(COMPARATORS) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.weather_list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvCity: TextView = itemView.findViewById(R.id.tvCityName)
        private val tvCountry: TextView = itemView.findViewById(R.id.tvCountryName)
        private var tvTemp: TextView = itemView.findViewById(R.id.tvTemp)
        private val tvWeatherInfo: TextView = itemView.findViewById(R.id.tvWeatherInfo)
        private val lottieImage: LottieAnimationView = itemView.findViewById(R.id.lottieImage)
        fun bind(city: City) {
            tvCity.text = city.name
            tvCountry.text = city.country
            tvWeatherInfo.text = city.shortDescription
            tvTemp.text = Utility.getCelsiusFromKelvin(temp = city.temp)
            lottieImage.setAnimation(
                Utility.getWeatherJsonInputStream(
                    city,
                    tvWeatherInfo.resources
                )
            )
        }
    }

    object COMPARATORS : DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.name === newItem.name
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }
    }
}