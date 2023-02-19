package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.API_KEY
import com.example.weatherfetcher.CITY
import com.example.weatherfetcher.feature.weather_screen.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

// интерфейс ипользуется для отправки запрсов в сеть
interface WeatherApi {

    @GET("weather")
   suspend fun getWeather(
        @Query("q") query: String = CITY,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ) : Weather



}