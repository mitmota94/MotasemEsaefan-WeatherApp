package com.example.motasemesaefanweatherapp2.repository

import android.util.Log
import com.example.motasemesaefanweatherapp2.api.ApiService
import com.example.motasemesaefanweatherapp2.model.WeatherForecastResponse
import kotlinx.coroutines.processNextEventInCurrentThread


interface  WeatherForecastRepository{
    suspend fun getWeatherForecast(q: String): WeatherForecastResponse
}


class  WeatherForecastRepositoryImp(private val service: ApiService = ApiService.getApiService()):WeatherForecastRepository{

    override suspend fun getWeatherForecast(cityName: String): WeatherForecastResponse {
       val response = service.getWeatherForecast(q = cityName)
        println("**********************************************************" + response.body())
        return if (response.isSuccessful){
            response.body()!!
        }else{
            Log.d("asd","network is shit2")
           WeatherForecastResponse(emptyList())
        }
    }

}
