package com.example.motasemesaefanweatherapp2.api

import com.example.motasemesaefanweatherapp2.model.WeatherForecastResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    //const var APP_Key = "01c645edf022d4d866440ea4bfddd443"


//https://api.openweathermap.org/data/2.5/forecast?q={city}&appid=01c645edf022d4d866440ea4bfddd443
    @GET("forecast/")
    suspend fun  getWeatherForecast(
        @Query("q") q: String = "Atlanta",
        @Query("appid") appid: String = "01c645edf022d4d866440ea4bfddd443"
    ):Response<WeatherForecastResponse>


    companion object{

        private var instance: ApiService? = null

        fun getApiService(): ApiService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return instance!!
        }

    }

}