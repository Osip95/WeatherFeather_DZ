package com.example.weatherfetcher.feature.weather_screen.data


import com.example.weatherfetcher.feature.weather_screen.domain.WeatherRepo
import com.example.weatherfetcher.feature.weather_screen.ui.model.WeatherModel

// репозиторий данных
class WeatherRepoImpl(private val weatherRemouteSource: WeatherRemouteSource): WeatherRepo {
    override suspend fun getWeather(): WeatherModel {
        return weatherRemouteSource.getWeather().toDomain()
    }

}