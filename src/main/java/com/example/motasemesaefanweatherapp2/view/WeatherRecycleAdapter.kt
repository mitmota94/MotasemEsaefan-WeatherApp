package com.example.motasemesaefanweatherapp2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.motasemesaefanweatherapp2.databinding.ActivityMainBinding
import com.example.motasemesaefanweatherapp2.databinding.WeatherListItemBinding
import com.example.motasemesaefanweatherapp2.model.WeatherForecast


class WeatherRecycleAdapter(
    private val weatherList : MutableList<WeatherForecast> = mutableListOf(),
   private val openDetails: (WeatherForecast) -> Unit
):RecyclerView.Adapter<WeatherRecycleAdapter.WeatherViewHolder>(){

    fun setWeatherList(newList: List<WeatherForecast>){
        weatherList.clear()
        weatherList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(
        private val binding: WeatherListItemBinding
    ): RecyclerView.ViewHolder(binding.root){

        // var newFeelLikernd  : Int = newfeelsLike.toInt()
        //var temp = weatherForecast.main.temp.toString()
        fun bind(weatherForecast: WeatherForecast){
       // var tempNew = weatherForecast.main.temp.toString()
            //var tempRnd : Int = tempNew.toInt()
        binding.tvDesc.text = weatherForecast.weather[0].main.toString()
            binding.tvTemp.text = weatherForecast.main.temp.toInt().toString() + "  "+ "K"
           // binding.tvTemp.text = tempRnd.toString()
            binding.root.setOnClickListener {
                openDetails(weatherForecast)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      WeatherViewHolder(
        WeatherListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

      )


    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount() = weatherList.size

}