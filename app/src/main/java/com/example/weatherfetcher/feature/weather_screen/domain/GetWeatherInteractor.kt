package com.example.weatherfetcher.feature.weather_screen

import com.example.weatherfetcher.base.Either
import com.example.weatherfetcher.base.attempt
import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepoImpl
import com.example.weatherfetcher.feature.weather_screen.domain.WeatherRepo
import com.example.weatherfetcher.feature.weather_screen.data.model.Weather
import com.example.weatherfetcher.feature.weather_screen.ui.model.WeatherModel
// интерактор служит для обобщения данных из  разных репозиториев, в данном случае источник один
class GetWeatherInteractor (private val weatherRepo: WeatherRepo) {

    suspend operator fun invoke(): Either<Throwable, WeatherModel> {
      return attempt {   weatherRepo.getWeather() }
    }


}