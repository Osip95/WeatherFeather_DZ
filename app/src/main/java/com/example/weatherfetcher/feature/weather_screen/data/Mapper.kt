package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.Weather
import com.example.weatherfetcher.feature.weather_screen.ui.model.WeatherModel
// маппер - используется для преобразования моделей: из той котрую мы получили из сети в модель котрая используется в приложении
// используется для того что бы в случае получения данных с другого сайта или из БД непришлось менять логку приложения
fun Weather.toDomain() = WeatherModel(
    temperature = this.main.temperature
)