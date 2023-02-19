package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.Weather

// источник котрый работает с сетью
// если бы работали с внутренним хранилищем данных, то в проекте был и LocalRemouteSource
class WeatherRemouteSource(private val api: WeatherApi) {

    // TODO add query
    suspend fun getWeather(): Weather = api.getWeather()
}
