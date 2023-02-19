package com.example.weatherfetcher.feature.weather_screen.domain


import com.example.weatherfetcher.feature.weather_screen.ui.model.WeatherModel
// нитерфейс репозиторя
interface WeatherRepo {
   suspend fun getWeather(): WeatherModel
   }